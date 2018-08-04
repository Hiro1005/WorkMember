// create a users class
class Users{
    
    private int Id;
    private String Fname;
    private String Lname;
    private int Age;
    
    public Users(int id,String name,String branch,int age){
        this.Id = id;
        this.Fname = name;
        this.Lname = branch;
        this.Age = age;
    }
    
    //getIdメソッドを実行することで、ユーザーコンストラクタへ　idの値を返す
    public int getId(){
        return this.Id;
    }
    
    //getFnameメソッドを実行することで、ユーザーコンストラクタへ　Fnameの値を返す
    public String getFname(){
        return this.Fname;
    }
    
    //getLnameメソッドを実行することで、ユーザーコンストラクタへ　Lnameの値を返す
    public String getLname(){
        return this.Lname;
    }
    
    //getAgeメソッドを実行することで、ユーザーコンストラクタへ　Ageの値を返す
    public int getAge(){
        return this.Age;
    } 
}

