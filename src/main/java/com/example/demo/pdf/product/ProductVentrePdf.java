package com.example.demo.pdf.product;

import com.example.demo.entity.Produit;
import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class ProductVentrePdf {

    public List<Produit> produitList;

    public ProductVentrePdf(List<Produit> produitList) {
        this.produitList = produitList;
    }

    private void writeTableHeader1(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.WHITE);
        cell.setPadding(5);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK);

        cell.setPhrase(new Phrase("N° d'Article", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Filière", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Descriptif", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Dimension (cm)", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Poids (en g)", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Q", font));
        table.addCell(cell);



    }

    private void writeTableHeader2(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.WHITE);
        cell.setPadding(5);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK);

        cell.setPhrase(new Phrase("Produit destiné à la vente", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Photo", font));
        table.addCell(cell);
    }

    private void writeTableHeader3(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.WHITE);
        cell.setPadding(5);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);


        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK);


        Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font1.setColor(Color.BLACK);
        Paragraph p = new Paragraph("Catalogue des ventes: FERRONNERIE PV N°2", font1);


        //cell.setPhrase(new Phrase("Date du PV du CI: 06/06/2021", font));
        cell.setPhrase(new Phrase(p));
        table.addCell(cell);



    }


    private void writeTableData1(PdfPTable table,Produit produit) throws BadElementException, IOException {



            Image im=Image.getInstance("C:\\application_web_gestion_entretiens_produits_mobilités\\produits-images\\"+produit.getId()+"\\"+produit.getImage());

            table.addCell(String.valueOf(produit.getId()));
            table.addCell(produit.getFiliere().getNom());
            table.addCell(produit.getDescriptif() );

            table.addCell(produit.getDimension());
            table.addCell(String.valueOf(produit.getPoid()));
            table.addCell(String.valueOf(produit.getQuantite()));
            table.addCell("Code inventaire vente: "+produit.getCode()+"\n\n\n  PVF: "+produit.getPrix_unitaire()+" (DHS)");
            table.addCell(String.valueOf(produit.getId()));
            table.addCell(im);



    }

    private void writeTableData2(PdfPTable table,Produit produit) throws BadElementException, IOException {


            Image im=Image.getInstance("C:\\application_web_gestion_entretiens_produits_mobilités\\produits-images\\"+produit.getId()+"\\"+produit.getImage());
            table.addCell(String.valueOf(produit.getId()));
            table.addCell(im);



    }




    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLACK);

        Paragraph p = new Paragraph("Catalogue des ventes: FERRONNERIE PV N°2", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);


        PdfPTable table3=new PdfPTable(1);
        table3.setWidthPercentage(100f);
        table3.setWidths(new float[] {7f});
        table3.setSpacingBefore(10);

        writeTableHeader3(table3);
        document.add(table3);



        for(Produit produit: produitList){

            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100f);
            table.setWidths(new float[] {2f, 3f, 3.0f, 3.0f, 2f,1.5f});
            table.setSpacingBefore(10);

            PdfPTable table2 = new PdfPTable(2);
            table2.setWidthPercentage(100f);
            table2.setWidths(new float[] {5f,5f});
            table2.setSpacingBefore(0);

            writeTableHeader1(table);
            writeTableData1(table,produit);
            writeTableHeader2(table2);
            writeTableData2(table2,produit);


            document.add(table);
            document.add(table2);

        }




        document.close();

    }
}
