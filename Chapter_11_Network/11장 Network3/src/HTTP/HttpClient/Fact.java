package HTTP.HttpClient;

import java.util.Date;

//Request를 통해 Json(String)으로 response를 받으면
//gson이 Fact객체로 Mapping해준다
public class Fact {
    private final String _id;
    private final Status status;
    private final String user;
    private final String text;
    private final String type;
    private final String source;
    private final boolean bool;
    private final Date createdAt;
    private final Date updatedAt;
    private final int _v;

    public Fact(String id, Status status, String user, String text, String type, String source, boolean bool, Date createdAt, Date updatedAt, int v) {
        _id = id;
        this.status = status;
        this.user = user;
        this.text = text;
        this.type = type;
        this.source = source;
        this.bool = bool;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        _v = v;
    }

    class Status {
        private final String verified;
        private final int sentCount;

        private Status(String verified, int sentCount) {
            this.verified = verified;
            this.sentCount = sentCount;
        }

        @Override
        public String toString() {
            return "status : {" +
                    "\"verified\" : " + verified + ", \n" +
                    "\"sentCount\" : " + sentCount + "\n},";
        }
    }

    @Override
    public String toString() {
        return String.format(status.toString() + "id : %s,\ntype : %s,\ndeleted : %s,\nuser : %s,\ntext : %s,\ncreated At : %s,\nupdatedAt : %s,\n",
                _id, type, bool, user, text, createdAt, updatedAt);
    }
}
