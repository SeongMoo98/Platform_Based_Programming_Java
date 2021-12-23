package com.fm.repository;
/**
 * Entity
 * Entity는 Relational Database의 Table을 Represent
 * 각 Entity instance가 한 row를 나타낸다
 *
 * 1. argument없는 Constructor가 있어야한다
 * 2. final로 선언된 함수, instance variable이 있으면 안된다
 * 3. Instance variable은 public으로 선언하면 안된다
 * 4. 따라서 Instace Variable은 Getter, Setter로 다룬다
 * 5. persistence field : Instance variables
 *                        여러가지 Type가능
 *                        OR Mapping annotations를 명시한다
 * OR Mappin Annotation : @OneToOne, @ManyToOne, @OneToMany, @ManyToMany
 * 6. persistence properties : Methods
 *                             Getter, Setter 사용
 * 7. Entity는 Primary Key가 반드시 존재해야 한다
 * Primary Key : unique object identifier - 그 하나로 객체를 특정할 수 있다
 * Foreign Key : Relation에서 사용되는 key
 *
 * Owning Side : Database의 Relationship을 바꿀 수 있는 권한을 가진 Entity
 *               보통 1:N 에서 N쪽이 가지고있다
 *               Annotation - @JoinColumn - foreign key를 나타냄, Owning Size쪽에서 흔하다
 *                          - @OneToMany(mappedBy="") - Owning Size를 참조한다
 *               
*/

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "PLAYER")
public class Player{
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;
    @Column(name="SHORT_NAME")
    private String name;
    @Column(name="HEIGHT_CM")
    private int height;
    @ManyToOne(optional = false)
    @JoinColumn(name="COUNTRY_ID")
    private Country country;
    @ManyToOne(optional = false)
    @JoinColumn(name="CLUB_ID")
    private Club club;
    @Column(name="OVERALL")
    private int overall;
    @Column(name="PLAYER_POSITIONS")
    private String positions;
    private static Long MAXID = 0L;
    public Player() {}

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getHeight() {
        return height;
    }
    public Country getNationality() {
        return country;
    }
    public Club getClub() {
        return club;
    }
    public int getOverall() {
        return overall;
    }
    public List<String> getPositions() {
        return Arrays.asList(positions.replaceAll("\"", "").split(","));
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setNationality(Country country) {
        this.country = this.country;
    }
    public void setClub(Club club) {
        this.club = club;
    }
    public void setOverall(int overall) {
        this.overall = overall;
    }
    public void setPositions(String positions) {
        this.positions = positions;
    }
    @Override
    public String toString() {
        return String.format("%d,%s,%d,%s,%s,%d,\"%s\"", id, name, height, country.getName(), club.getName(), overall, positions.toString().replaceAll("\\[|\\]", ""));
    }
}