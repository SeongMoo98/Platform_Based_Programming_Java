package TextArea;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;

enum Mode{
    COMPLETION, INSERT;
}
public class TextAreaView extends JFrame implements DocumentListener {
    private List<String> words = new ArrayList<>();
    private JTextArea textArea;
    private Mode mode;
    public TextAreaView(String title, List<String> words){
        this.words = words;

        setTitle(title);
        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Try typing 'spectacular' or 'Swing'...");
        Font font = new Font(label.getFont().getName(),label.getFont().getStyle(), 24);
        label.setFont(font);

        //textArea = new JTextArea(5,20); // 5줄, 한 줄에 20
        textArea = new JTextArea();
        textArea.setColumns(20);
        textArea.setRows(5);
        textArea.setFont(font);
        textArea.setLineWrap(true); //가로 scroll이 안 생기게 wrap
        //DocumentListener???
        //model을 get해서 Document에 Event가 있는지 listener
        textArea.getDocument().addDocumentListener(this);

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(label);
        add(scrollPane);

        //InputMap
        //an input map binds key strokes to action name
        //keyEvent가 발생하면 그 acion의 이름을 지정해줌
        InputMap im = textArea.getInputMap();
        ActionMap am = textArea.getActionMap();
        im.put(KeyStroke.getKeyStroke("ENTER"),"commit");
        am.put("commit", new CommitAction());
    }

    private class CommitAction extends AbstractAction{
        public void actionPerformed(ActionEvent e) {
            if (mode == Mode.COMPLETION) {
                int pos = textArea.getSelectionEnd(); // textArea의 마지막위치
                textArea.insert(" ", pos);
                textArea.setCaretPosition(pos + 1);
                mode = Mode.INSERT;
            } else {
                textArea.replaceSelection("\n");
            }
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e){
        int pos = e.getOffset();
        String content =null;
        try {
            content = textArea.getText(0, pos+1);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }

        //Find Where the word starts
        int w;
        for(w=pos; w>=0; w--){
            if(!Character.isLetter(content.charAt(w)));
                break;
        }
        if(pos -w <2)
            return;

        String prefix = content.substring(w+1).toLowerCase();
        // The insertion point is defined as the point at which the key would be inserted into the array:
        // the index of the first element greater than the key ((-(insertion point) - 1)
        int n = Collections.binarySearch(words,prefix);
        if( n < 0 && -n <=words.size()){
            String match = words.get(-n-1);
            if(match.startsWith(prefix)){
                //A Completion is found
                String completion = match.substring(pos-w);
                // We cannot modify Document from within notification,
                // so we submit a task that does the change later
                SwingUtilities.invokeLater(new CompletionTask(completion, pos+1));
            }
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }

    private class CompletionTask implements Runnable{
        String completion;
        int position;
        CompletionTask(String completion, int position){
            this.completion =completion;
            this.position=position;
        }
        @Override
        public void run(){
            textArea.insert(completion,position);
            textArea.setCaretPosition(position+completion.length());
            textArea.moveCaretPosition(position);
            mode=Mode.COMPLETION;
        }
    }
}
