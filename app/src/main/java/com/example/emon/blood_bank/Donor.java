package com.example.emon.blood_bank;



public class Donor {

    private int id;
    private String name;
    private int age;
    private String phone;
    private String password;
    private String bloodGroup;
    private String location;

    public Donor(String name , int age , String phone , String password, String bloodGroup , String location)
    {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.password = password;
        this.bloodGroup = bloodGroup;
        this.location = location;
    }

    public void setId(int id) { this.id = id; }

    public int getId() { return id; }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getBloodGroup()
    {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup)
    {
        this.bloodGroup = bloodGroup;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }
}
