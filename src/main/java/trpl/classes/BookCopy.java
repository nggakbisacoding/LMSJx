/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trpl.classes;

import java.io.Serializable;

/**
 *
 * @author Fandead
 */
public class BookCopy implements Serializable {
    
        private int copyNumber;
        private Book book;
        private boolean available;

	public BookCopy(Book book, int copyNumber, boolean available) {
		this.copyNumber = copyNumber;
		this.book = book;
		this.available = available;
	}

	public int getCopyNumber() {
		return copyNumber;
	}

	public Book getBook() {
		return book;
	}

	public boolean isAvailable() {
		return available;
	}

	public void changeAvailability() {
		available = !available;
	}

	@Override
	public String toString() {
		return book.getTitle() + " #" + copyNumber;
        }
}
