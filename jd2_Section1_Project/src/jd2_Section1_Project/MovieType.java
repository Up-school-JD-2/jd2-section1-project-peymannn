package jd2_Section1_Project;

public enum MovieType {
	Horror(1),
    SciFi(2),
    RomCom(3);
	 private int id; 
     private MovieType(int id) {
         this.id = id;
     }
     public int getId() {
         return this.id;
     }
     public static MovieType fromId(int id) {
             for (MovieType type : values()) {
                 if (type.getId() == id) {
                     return type;
                 }
             }
             return null;
         }
}
