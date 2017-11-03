/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.util.Scanner;

/**
 *
 * @author AHMED 50070
 */
public class LibrarySystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Manager Emp = new Manager();

        Scanner input = new Scanner(System.in);

        //////// Adding Books To the System //////////// 
        Book b1 = new Book("هيبتا", "محمد صادق ");
        Book b2 = new Book("أنتخريستوس", "احمد خالد مصطفي");
        Book b3 = new Book("ثلاثيه غرناطه", "مصطفي محمود ");
        Book b4 = new Book("كيغاار", "مني حسين ");
        Book b5 = new Book("لاتحزن", "عائض القرنى ");
        Book b6 = new Book("المنجم", "محمود الجندي ");
        Book b7 = new Book("ارض السافلين", "احمد خالد مصطفي ");
        Book b8 = new Book("قصر الشوق", "نجيب محفوظ");
        Book b9 = new Book("الايام", "طه حسين ");
        Book b10 = new Book("عقبه بن نافع", " ");
        Book b11 = new Book("خديجه", "محمود الجندي ");
        Book b12 = new Book("اسماء بنت ابى بكر ", "محمود الجندي ");
        Book b13 = new Book("ارض الصالحين", "مصطفي بكري ");
        Book b14 = new Book("ارض الاله", "احمد مراد");
        Book b15 = new Book("الفيل الازرق ", "احمد مراد ");

        Emp.addBook(b1);
        Emp.addBook(b2);
        Emp.addBook(b3);
        Emp.addBook(b4);
        Emp.addBook(b5);
        Emp.addBook(b6);
        Emp.addBook(b7);
        Emp.addBook(b8);
        Emp.addBook(b9);
        Emp.addBook(b10);
        Emp.addBook(b11);
        Emp.addBook(b12);
        Emp.addBook(b13);
        Emp.addBook(b14);
        Emp.addBook(b15);

/////////////////////////////////////////////////////////////////////////////////
        /// print List of Books
        //Emp.printlistBook();
////////////////////////////////////////////////////////////////////////////////        
        ///// here i use Polymorphism and register employee to the system 
        /// create deafult members and add it to the system 
        Member G = new Student(13, "Omar", Emp);
        Member G1 = new GoldenMember(14, "Ahmed", Emp);
        Member G2 = new SilverMember(15, "khaled", Emp);

        Emp.addMember(G);
        Emp.addMember(G1);
        Emp.addMember(G2);

/////////////////////////////////////////////////////////////////////////////////
        System.out.println(" \t\t-------WELCOME TO LIBRARY MANAGEMENT SYSTEM ------- ");

        int close = 1;
        while (close == 1) {

            System.out.println("Press \n 1 add member \n 2 Borrow Book"
                    + " \n 3 return Book \n 4 print Book Details \n 5 print memebr Details "
                    + " \n 6 print Borrow List"
                    + " \n Press 0 to Exit");
            switch (input.nextInt()) {
                case 1:
                    System.out.println("Enter Name :");
                    String name = input.next();
                    System.out.println("Enter ID :");
                    int ID = input.nextInt();
                    System.out.println("Choose type of membership \n1 --> Golden \n2 --> Silver \n3 --> Student");

                    int type = input.nextInt();
                    if (type == 1) {

                        Emp.addMember(new GoldenMember(ID, name, Emp));
                    } else if (type == 2) {

                        Emp.addMember(new SilverMember(ID, name, Emp));
                    } else if (type == 3) {
                        Emp.addMember(new Student(ID, name, Emp));
                    }
                    System.out.println("----------------------------------------------------------------------------------");
                    break;
                case 2:

                    System.out.println("Enter ID Of Book you want to borrow");
                    int BookID = input.nextInt();
                    System.out.println("Enter ID Of Memeber that wish to borrow");
                    int Member_ID = input.nextInt();

                    Book B = Emp.getBook(BookID);
                    Member M = Emp.getMember(Member_ID);

                    if (B != null && M != null) {

                        System.out.println("Enter Date of Borrow ");
                        String date = input.next();
                        System.out.println("Enter Borrow ID ");
                        int Id = input.nextInt();
                        System.out.println("Enter Comments ");
                        String Comments = input.nextLine();

                        M.borrowing_book(B, Id, "date", Comments);

                    } else {
                        System.out.println("you Entered Error ID Please Try Again ");
                    }
                    System.out.println("----------------------------------------------------------------------------------");
                    break;

                case 3:

                    System.out.println("Enter Correct ID of Book you Want to Return: ");
                    int B_id = input.nextInt();

                    System.out.println("Enter you Member ID : ");
                    int M_Id = input.nextInt();

                    Book b = Emp.getBorrowedBook(B_id);
                    Member m = Emp.getMember(M_Id);

                    if ( m != null) {

                        m.return_book(b);
                        
                    } else {
                        System.out.println("Error You Enterd ID please Try again ");
                        System.out.println("----------------------------------------------------------------------------------");
                    }

                    System.out.println("----------------------------------------------------------------------------------");

                    break;
                case 4:
                    Emp.printlistBook();
                    System.out.println("----------------------------------------------------------------------------------");

                    break;
                case 5:
                    Emp.printListMember();
                    System.out.println("-----------------------------------------------------------------------------------");
                    break;
                case 6:
                    System.out.println("Enter Member ID : ");
                    int id = input.nextInt();
                    Member member = Emp.getMember(id);

                    if (member != null) {

                        Emp.printBorrowList(member);
                        
                    } else {
                        System.out.println("Error You Entered un Correct Member ID or it's not Exists");
                    }
                    break;
                default:
                    close = 0;

            }

        }

        System.out.println("\t\t------ Thank you to use Library Managemnet Systm -------");
    }

}
