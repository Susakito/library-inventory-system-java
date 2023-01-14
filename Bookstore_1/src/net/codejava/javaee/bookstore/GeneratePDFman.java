package net.codejava.javaee.bookstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;

public class GeneratePDFman {

	public static void main(String[]args) throws FileNotFoundException, SQLException {
			File file = new File("ManilaLibrary.pdf");
			PdfWriter writer = new PdfWriter(file);
			PdfDocument pdfDoc = new PdfDocument(writer);
			Document doc = new Document(pdfDoc);
			pdfDoc.setDefaultPageSize(PageSize.A4);
			
			
			
			String url = "jdbc:mysql://localhost:3306/Bookstore";
			Connection conn = DriverManager.getConnection(url, "root", "12345");
		    PreparedStatement ps = null;
		
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM man");
			
			//Table table = new Table(UnitValue.createPercentArray(5)).useAllAvailableWidth();
			
			/*table.addCell("ID");
			table.addCell("Title");
			table.addCell("Author");
			table.addCell("Status");
			
			doc.add(table);*/
			
			Table table = new Table(4);
	        table.addCell((new Cell().add(new Paragraph("ID"))));

	        table.addCell((new Cell().add(new Paragraph("Title"))));
	        
	        table.addCell((new Cell().add(new Paragraph("Author"))));

	        table.addCell((new Cell().add(new Paragraph("Status"))));

	       /* table.addCell("1.0");
	        table.addCell("1.1");
	        table.addCell("1.2");
	        table.addCell("2.1");
	        table.addCell("2 .2");
	        table.addCell("2.3");*/

	       
			
			
			while(rs.next())
			{//DAPAT PANGALAN MISMO NG COLUM DI PWEDE INDEX I.E.(BAWAL "0" DAPAT "ID")
				
				/*Paragraph para = new Paragraph(rs.getInt("book_id")+ " " +rs.getString("title") + " " +rs.getString("author")
				+ " " +rs.getString("stat"));*/
				table.addCell(Integer.toString(rs.getInt("book_id")));
				table.addCell(rs.getString("title"));
				table.addCell(rs.getString("author"));
				table.addCell(rs.getString("stat"));
				
				
				//doc.add(para);
				doc.add(new Paragraph(" "));
			}
			 doc.add(table);
			doc.close();

		}

}
