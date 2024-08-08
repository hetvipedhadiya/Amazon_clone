import java.util.Scanner;
public class BookDemo{
	public static void main(String[] args) {
		Scanner scString = new Scanner(System.in);
		Scanner scNumber = new Scanner(System.in);
		System.out.println("Enter no of books");
		int n = scNumber.nextInt();

		BookDetails[] books = new BookDetails[n];

		for(int i=0;i<n;i++){
			System.out.println("Enter Title of book "+ (i+1));
			String title = scString.nextLine();

			System.out.println("Enter Author of book "+ (i+1));
			String authorName = scString.nextLine();

			System.out.println("Enter Price of book "+ (i+1));
			double price = scNumber.nextDouble();

			System.out.println("Enter Stock of book "+ (i+1));
			int noOfBookAvailable = scNumber.nextInt();

			books[i] = new BookDetails(title,authorName,price,noOfBookAvailable);
		}
		while(true){
			System.out.println("Enter 1 for search, 2 for update, 3 to display books");
			int choice = scNumber.nextInt();

			if(choice==1){
				System.out.println("Enter search word");
				String searchWord = scString.nextLine();				
				for(int i=0;i<n;i++){
					if(books[i].search(searchWord)){
						System.out.println("Book Title = "+books[i].title);
					}
				}
			}
			else if(choice==2){
				System.out.println("Enter Title of the book");
				String searchWord = scString.nextLine();	
				System.out.println("Enter positive number to purchase or negative number for sell");
				int noOfBooks = scNumber.nextInt();
				for(int i=0;i<n;i++){
					if(books[i].search(searchWord)){
						books[i].updateStock(noOfBooks);
					}
				}
			}
			else if(choice==3){
				for(int i=0;i<n;i++){
					System.out.println("Title of book["+(i+1)+"]= "+books[i].title);
					System.out.println("Author of book["+(i+1)+"]= "+books[i].authorName);
					System.out.println("Price of book["+(i+1)+"]= "+books[i].price);
					System.out.println("Stock of book["+(i+1)+"]= "+books[i].noOfBookAvailable);
				}
			}
			else{
				break;
			}
		}
	}
}

class Book{
	String title;
	String authorName;
	public Book(String title, String authorName){
		this.title = title;
		this.authorName = authorName;
	}
}

class BookDetails extends Book{
	double price;
	int noOfBookAvailable;
	public BookDetails(String title, String authorName, double price, int noOfBookAvailable){
		super(title,authorName);
		this.price = price;
		this.noOfBookAvailable = noOfBookAvailable;
	}

	public boolean search(String searchWord){
		if(title.indexOf(searchWord)>-1 || authorName.indexOf(searchWord)>-1){
			return true;
		}
		else{
			return false;
		}
	}

	public void updateStock(int noOfBooks){
		noOfBookAvailable += noOfBooks;
	}
}