package main.java.testingtheconcepts;

final class Employee{
   private final String empName;
   private final int age;
   private final Address address;
   public Employee(String name, int age, Address address) {
      super();
      this.empName = name;
      this.age = age;
      this.address = new Address(address.getAddressType(),address.getAddress(), address.getCity());
   }
   public String getEmpName() {
      return empName;
   }
   public int getAge() {
      return age;
   }
   /* public Address getAddress() {
      return address;
      }
   */
   public Address getAddress() throws CloneNotSupportedException {
      return (Address) address.clone();
   }
}