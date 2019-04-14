package com.example.appliudemy;

/*TODO kotlin vers java appel class Adress codée en kotlin*/
public class Admin {

    private String name;
    private int age;
    private Adress adress;

    public Adress getAdress() {
        return adress;
    }

    public Admin() {
        adress = new Adress("Paris", "France");
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
