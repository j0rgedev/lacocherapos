package model.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPHeaderCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import model.entity.CartDish;
import model.entity.Client;
import model.entity.Order;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class ReceiptGenerator {


    public static void generateReceipt(Order order, List<CartDish> orderDishes) throws DocumentException, FileNotFoundException {

        String receiptHeader = receiptHeader(order);
        String lineSeparator = """           
                ==================================
                """;
        String receiptSummary = """  
                Subtotal:\t""" + order.getSubtotal() + """     
                    
                IGV:\t""" + order.getIgv() + """
                
                Total:\t""" + order.getTotalAmount() + """
                """;
        String receiptFooter = """
              
              
                ==================================
                Gracias por su compra
                ==================================
                """;

        String desktopPath = System.getProperty("user.home") + File.separator + "Desktop" + File.separator;
        String pdfFilePath = desktopPath + "receipt.pdf";

        Font font = new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL);
        Font headerFont = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD);

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(95);
        table.setWidths(new int[]{20, 40, 20, 20});
        PdfPHeaderCell headerCell = new PdfPHeaderCell();
        headerCell.setBorderWidth(0);
        headerCell.setBorderWidthBottom(1);
        headerCell.setPhrase(new Phrase("Cant", headerFont));
        table.addCell(headerCell);
        headerCell.setPhrase(new Phrase("Plato", headerFont));
        table.addCell(headerCell);
        headerCell.setPhrase(new Phrase("Prec.", headerFont));
        table.addCell(headerCell);
        headerCell.setPhrase(new Phrase("Total", headerFont));
        table.addCell(headerCell);

        for (CartDish dish : orderDishes) {
            PdfPCell cell = new PdfPCell();
            cell.setBorderWidth(0);
            cell.setPhrase(new Phrase(String.valueOf(dish.getQuantity()), font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(dish.getDish().getName(), font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(dish.getDish().getPrice()), font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(dish.getSubtotal()), font));
            table.addCell(cell);
        }

        table.getDefaultCell().setBorder(0);

        float tableHeight = table.getTotalHeight();
        Document document = new Document(new Rectangle(200, tableHeight + 400));
        document.setMargins(10, 10, 10, 10);
        PdfWriter.getInstance(document, new FileOutputStream(pdfFilePath));
        document.open();
        document.add(new Paragraph(receiptHeader, font));
        document.add(table);
        document.add(new Paragraph(lineSeparator, font));
        Paragraph summary = new Paragraph(receiptSummary, font);
        summary.setAlignment(2);
        document.add(summary);
        Paragraph footer = new Paragraph(receiptFooter, font);
        footer.setAlignment(1);
        document.add(footer);
        System.out.println("tableHeight: " + tableHeight);
        document.close();
        System.out.println("PDF generado en: " + pdfFilePath);
    }

    private static String receiptHeader(Order order){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        String formattedDate = LocalDate.now().format(formatter);
        Client client = order.getClient();
        return """
                ============ RECIBO ==============
                Fecha:\s""" + formattedDate + """

                Nro. de orden:\s""" + order.getId() + """
                
                Cliente:\s""" + client.getName() + " " + client.getLastName() + """
                
                DNI:\s""" + client.getDni() + """

                ==================================

                """;
    }

}
