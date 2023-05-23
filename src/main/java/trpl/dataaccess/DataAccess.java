/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trpl.dataaccess;

/**
 *
 * @author Fandead
 */
import java.util.HashMap;
import java.util.List;

import trpl.classes.*;

public interface DataAccess {
	//User
	public void saveUser(User user);
	public HashMap<String, User> readUsers();
	
	//Members
	public void saveMember(Member member);
	public HashMap<Integer, Member> readMembers();
	public List<Member> readMembersList();
	public Member findMember(int id);
	
	//Book
	public void saveBook(Book book);
	public HashMap<String, Book> readBooks();
	public List<Book> readBooksList();
	public Book findBook(String isbn);
	
	//CheckoutRecord
	public void saveCheckoutRecord(CheckoutRecord checkout);
	public HashMap<Integer, CheckoutRecord> readCheckoutRecords();
	public List<CheckoutRecord> readCheckoutRecordsList();
	
	//Checkout of Member
	public List<CheckoutRecord> searchCheckout(int id);
        
        public void saveReservationChair(Chair chair);
        public void cancelReservationChair(Chair chair);
        public List<Chair> readReservationChairList();
        public HashMap<Integer, Chair> readReservationChair();
}

