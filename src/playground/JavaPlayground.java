package playground;

import java.util.LinkedList;

public class JavaPlayground {
    static LinkedList<String> list = new LinkedList<>();
    public static void main(String args[]) {
//        B objB = new B();
//        objB.eat();

        String str = "aab";
        permutations(str, "");
        list.forEach(System.out::println);

        Address add1 = new Address("Sunway");
        Employee emp1 = new Employee(1, add1);
        System.out.println(emp1);
        add1.setName("Splendour");
        System.out.println(emp1);
        emp1.getAddress().setName("Splendour");
        System.out.println(emp1);
    }

    public static void permutations(String str, String perm) {
        if(str.length() == 0) list.add(perm + str);
        for(int i = 0; i< str.length(); i++) {
            String remaining = str.substring(0, i) + "" +str.substring(i + 1);
            permutations(remaining, perm + Character.toString(str.charAt(i)));
        }
    }


}

class A {
    protected void eat() {
        System.out.println("Nom Nom");
    }
}

class B extends A {

}

class Address {
    private String name;
    public Address(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Employee{
    private final int id;
    private final Address address;
    public Employee(int id, Address address) {
        this.id = id;
        this.address = new Address(address.getName());
    }

    public int getId() {
        return id;
    }

    public Address getAddress() {
        return new Address(address.getName());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", address=" + address +
                '}';
    }
}

