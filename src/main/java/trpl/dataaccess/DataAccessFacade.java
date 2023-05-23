/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trpl.dataaccess;

/**
 *
 * @author Fandead
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import trpl.classes.*;

public class DataAccessFacade implements DataAccess {

	public static final String OUTPUT_DIR = System.getProperty("user.dir") + "\\src\\main\\java\\trpl\\dataaccess\\storage";
	public static final String DATE_PATTERN = "MM/dd/yyyy";

	Map<String, User> users = readUsers();
	Map<Integer, Member> members = readMembers();
	Map<String, Book> books = readBooks();
	Map<Integer, CheckoutRecord> records = readCheckoutRecords();
        Map<Integer, Chair> chairs = readReservationChair();

        /**
        *
        * @param user
        */
        @Override
	public void saveUser(User user) {
		users.put(user.getUsername(), user);
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.USERS.name());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(users);
                        System.out.println(path.toAbsolutePath());
		} catch (IOException e) {
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
	}

        /**
        *
        * @param member
        */
        @Override
	public void saveMember(Member member) {
		HashMap<Integer, Member> mmbrs = readMembers();
		int nextId=1;
		if(!mmbrs.isEmpty()) {
			
			nextId = mmbrs.get(mmbrs.size()).getMemberId()+1;
		}
		member.setMemberId(nextId);
		members.put(member.getMemberId(), member);
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.MEMBERS.name());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(members);
                        System.out.println(path.toAbsolutePath());
		} catch (IOException e) {
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
	}

        @Override
	public void saveBook(Book book) {
		books.put(book.getIsbn(), book);
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.BOOKS.name());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(books);
                        System.out.println(path.toAbsolutePath());
		} catch (IOException e) {
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
	}

        @Override
	public void saveCheckoutRecord(CheckoutRecord checkout) {
		records.put(checkout.getId(), checkout);
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.RECORDS.name());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(records);
                        System.out.println(path.toAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
	}

        @Override
	public HashMap<String, User> readUsers() {
		ObjectInputStream in = null;
		HashMap<String, User> anggota = new HashMap<>();
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.USERS.name());
			in = new ObjectInputStream(Files.newInputStream(path));
			anggota = (HashMap<String, User>) in.readObject();
                        System.out.println(path.toAbsolutePath());
		} catch (IOException | ClassNotFoundException e) {
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
		return anggota;
	}

        @Override
	public HashMap<Integer, Member> readMembers() {
		ObjectInputStream in = null;
		HashMap<Integer, Member> memberss = new HashMap<>();
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.MEMBERS.name());
			in = new ObjectInputStream(Files.newInputStream(path));
			memberss = (HashMap<Integer, Member>) in.readObject();
                        System.out.println(path.toAbsolutePath());
		} catch (IOException | ClassNotFoundException e) {
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
		return memberss;
	}

        @Override
	public HashMap<String, Book> readBooks() {
		ObjectInputStream in = null;
		HashMap<String, Book> bookss = new HashMap<>();
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.BOOKS.name());
			in = new ObjectInputStream(Files.newInputStream(path));
			bookss = (HashMap<String, Book>) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
		return bookss;
	}

	@Override
	public HashMap<Integer, CheckoutRecord> readCheckoutRecords() {
		ObjectInputStream in = null;
		HashMap<Integer, CheckoutRecord> checkoutrecords = new HashMap<>();
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.RECORDS.name());
			in = new ObjectInputStream(Files.newInputStream(path));
			checkoutrecords = (HashMap<Integer, CheckoutRecord>) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
		return checkoutrecords;
	}

        @Override
	public List<Member> readMembersList() {

		List<Member> memberr = new ArrayList<Member>();
		for (Member m : readMembers().values()) {
			memberr.add(m);
		}
		return memberr;
	}

	@Override
	public List<Book> readBooksList() {
		List<Book> buku = new ArrayList<>();
		for (Book b : readBooks().values()) {
			buku.add(b);
		}
		return buku;
	}

	@Override
	public List<CheckoutRecord> readCheckoutRecordsList() {
		List<CheckoutRecord> checkoutRecords = new ArrayList<>();
		for (CheckoutRecord cr : readCheckoutRecords().values()) {
			checkoutRecords.add(cr);
		}
		return checkoutRecords;
	}

	@Override
	public Member findMember(int id) {
		HashMap<Integer, Member> anggota = readMembers();
		return anggota.get(id);
	}

	@Override
	public Book findBook(String isbn) {
		HashMap<String, Book> buku = readBooks();
		return buku.get(isbn);
	}

	@Override
	public List<CheckoutRecord> searchCheckout(int id) {
		List<CheckoutRecord> checkoutRecords = new ArrayList<>();
		for (CheckoutRecord cr : readCheckoutRecords().values()) {
			if (cr.getMember().getMemberId() == id)
				checkoutRecords.add(cr);
		}
		return checkoutRecords;
	}
        
        @Override
	public void saveReservationChair(Chair chair) {
		chairs.put(chair.getChairNumber(), chair);
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.CHAIRS.name());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(records);
                        System.out.println(path.toAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
	}
        
        @Override  
	public HashMap<Integer, Chair> readReservationChair() {
		ObjectInputStream in = null;
		HashMap<Integer, Chair> chair = new HashMap<>();
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.CHAIRS.name());
			in = new ObjectInputStream(Files.newInputStream(path));
			chair = (HashMap<Integer, Chair>) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
		return chair;
	}

        @Override
        public void cancelReservationChair(Chair chair) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public List<Chair> readReservationChairList() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
}
