package com.bki.pdfgen;

import java.awt.Color;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import be.quodlibet.boxable.*;
import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.line.LineStyle;


public class TVCertPdfGen {
	

	
	public void genSamplePdf() {
		String outputFileName = "C:\\Users\\kedhy\\eclipse-workspace\\TLV_Table.pdf";
		
        try {
			// Create a new font object selecting one of the PDF base fonts
			PDFont fontPlain = PDType1Font.HELVETICA;
			PDFont fontBold = PDType1Font.HELVETICA_BOLD;
			PDFont fontItalic = PDType1Font.HELVETICA_OBLIQUE;
			PDFont fontMono = PDType1Font.COURIER;

			// Create a document and add a page to it
			PDDocument document = new PDDocument();
			PDPage page = new PDPage(PDRectangle.A4);
			// PDRectangle.LETTER and others are also possible
			PDRectangle rect = page.getMediaBox();
			// rect can be used to get the page width and height
			document.addPage(page);

			// Start a new content stream which will "hold" the to be created content
			PDPageContentStream cos = new PDPageContentStream(document, page);

			//Dummy Table
			float margin = 50;
			// starting y position is whole page height subtracted by top and bottom margin
			float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
			// we want table across whole page width (subtracted by left and right margin ofcourse)
			float tableWidth = page.getMediaBox().getWidth() - (2 * margin);

			boolean drawContent = true;
			float yStart = yStartNewPage;
			float bottomMargin = 70;
			// y position is your coordinate of top left corner of the table
			float yPosition = 550;

			BaseTable table = new BaseTable(yPosition, yStartNewPage,
			    bottomMargin, tableWidth, margin, document, page, true, drawContent);

			// the parameter is the row height
			Row<PDPage> headerRow = table.createRow(50);
			// the first parameter is the cell width
			Cell<PDPage> cell = headerRow.createCell(100, "Header");
			cell.setFont(fontBold);
			cell.setFontSize(20);
			// vertical alignment
			cell.setValign(VerticalAlignment.MIDDLE);
			// border style
			cell.setTopBorderStyle(new LineStyle(Color.BLACK, 10));
			table.addHeaderRow(headerRow);

			Row<PDPage> row = table.createRow(20);
			cell = row.createCell(30, "black left plain");
			cell.setFontSize(15);
			cell = row.createCell(70, "black left bold");
			cell.setFontSize(15);
			cell.setFont(fontBold);

			row = table.createRow(20);
			cell = row.createCell(50, "red right mono");
			cell.setTextColor(Color.RED);
			cell.setFontSize(15);
			cell.setFont(fontMono);
			// horizontal alignment
			cell.setAlign(HorizontalAlignment.RIGHT);
			cell.setBottomBorderStyle(new LineStyle(Color.RED, 5));
			cell = row.createCell(50, "green centered italic");
			cell.setTextColor(Color.GREEN);
			cell.setFontSize(15);
			cell.setFont(fontItalic);
			cell.setAlign(HorizontalAlignment.CENTER);
			cell.setBottomBorderStyle(new LineStyle(Color.GREEN, 5));

			row = table.createRow(20);
			cell = row.createCell(40, "rotated");
			cell.setFontSize(15);
			// rotate the text
			cell.setTextRotated(true);
			cell.setAlign(HorizontalAlignment.RIGHT);
			cell.setValign(VerticalAlignment.MIDDLE);
			// long text that wraps
			cell = row.createCell(30, "long text long text long text long text long text long text long text");
			cell.setFontSize(12);
			// long text that wraps, with more line spacing
			cell = row.createCell(30, "long text long text long text long text long text long text long text");
			cell.setFontSize(12);
			cell.setLineSpacing(2);

			table.draw();

			float tableHeight = table.getHeaderAndDataHeight();
			System.out.println("tableHeight = "+tableHeight);

			// close the content stream 
			cos.close();

			// Save the results and ensure that the document is properly closed:
			document.save(outputFileName);
			document.close();
		} catch (Exception e) {
			System.out.println("Exception Error message:"+e.getMessage());
			e.printStackTrace();
		}

	}
	
	
	
	public void genCertPdf() {
		String outputFileName = "C:\\Users\\kedhy\\eclipse-workspace\\TLV_Cert_CT5.pdf";
		
        try {
			// Create a new font object selecting one of the PDF base fonts
			
			PDFont fontMono = PDType1Font.COURIER;

			// Create a document and add a page to it
			PDDocument document = new PDDocument();
			PDPage page = new PDPage(PDRectangle.A4);
			// PDRectangle.LETTER and others are also possible
			PDRectangle rect = page.getMediaBox();
			// rect can be used to get the page width and height
			document.addPage(page);

			// Start a new content stream which will "hold" the to be created content
			PDPageContentStream cos = new PDPageContentStream(document, page);

			//Dummy Table
			float margin = 50;
			// starting y position is whole page height subtracted by top and bottom margin
			float yStartNewPage = page.getMediaBox().getHeight() - (2* margin);
			// we want table across whole page width (subtracted by left and right margin ofcourse)
			float tableWidth = page.getMediaBox().getWidth() - (2 * margin);

			boolean drawContent = true;
			float yStart = yStartNewPage;
			float bottomMargin = 70;
			// y position is your coordinate of top left corner of the table
			float yPosition = 550;
/////////////////////////cust table //////////////////////////////////			
			BaseTable custTable = new BaseTable(125, yStartNewPage ,
				    bottomMargin, tableWidth, margin, document, page, true, drawContent);
			Row<PDPage> ctRow = null;
			ctRow = custTable.createRow(15);
			Cell<PDPage>  ctCell = ctRow.createCell(50, "Customer Name:");
			ctCell.setTextColor(Color.BLACK);
			ctCell.setFontSize(12);
			ctCell.setFont(fontMono);
			// horizontal alignment
			ctCell.setAlign(HorizontalAlignment.RIGHT);
			ctCell.setBottomBorderStyle(new LineStyle(Color.BLACK, 1));
			//--------------
			ctCell = ctRow.createCell(50, "Kedar Datar");
			ctCell.setTextColor(Color.BLACK);
			ctCell.setFontSize(12);
			ctCell.setFont(fontMono);
			// horizontal alignment
			ctCell.setAlign(HorizontalAlignment.RIGHT);
			ctCell.setBottomBorderStyle(new LineStyle(Color.BLACK, 1));
			
			custTable.draw();
////////////////////////Data Table/////////////////////////////////
			BaseTable table = new BaseTable(yPosition, yStartNewPage,
			    bottomMargin, tableWidth, margin, document, page, true, drawContent);

			// the parameter is the row height
			Row<PDPage> row = null;
			Cell<PDPage> cell = null;
			row = table.createRow(20);
			cell = row.createCell(25, "1");
			cell.setTextColor(Color.BLACK);
			cell.setFontSize(15);
			cell.setFont(fontMono);
			// horizontal alignment
			cell.setAlign(HorizontalAlignment.RIGHT);
			cell.setBottomBorderStyle(new LineStyle(Color.BLACK, 1));
			cell = row.createCell(25, "0.01");
			cell.setTextColor(Color.BLACK);
			cell.setFontSize(15);
			cell.setFont(fontMono);
			cell.setAlign(HorizontalAlignment.RIGHT);
			cell.setBottomBorderStyle(new LineStyle(Color.BLACK, 1));

			//row = table.createRow(20);
			cell = row.createCell(25, "2");
			cell.setTextColor(Color.BLACK);
			cell.setFontSize(15);
			cell.setFont(fontMono);
			// horizontal alignment
			cell.setAlign(HorizontalAlignment.RIGHT);
			//cell.setBottomBorderStyle(new LineStyle(Color.BLACK, 2));
			cell = row.createCell(25, "0.02");
			cell.setTextColor(Color.BLACK);
			cell.setFontSize(15);
			cell.setFont(fontMono);
			cell.setAlign(HorizontalAlignment.RIGHT);
			//cell.setBottomBorderStyle(new LineStyle(Color.BLACK, 2));

			
			
			table.draw();

			float tableHeight = table.getHeaderAndDataHeight();
			System.out.println("tableHeight = "+tableHeight);

			// close the content stream 
			cos.close();

			// Save the results and ensure that the document is properly closed:
			document.save(outputFileName);
			document.close();
		} catch (Exception e) {
			System.out.println("Exception Error message:"+e.getMessage());
			e.printStackTrace();
		}

	}
	
	
	public static void main(String[] args) {
		TVCertPdfGen t = new TVCertPdfGen();
		t.genCertPdf();
	}
	
}
