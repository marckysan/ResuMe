package backend.logic;

import backend.exception.UnableSavePdfException;
import backend.model.resume.Resume;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResumeSaverImpl implements ResumeSaver {

    private final String PDF_FILE_EXTENSION = ".pdf";
    private final String DEFAULT_DATAPATH = "data";

    private final Font DEFAULT_FONT = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

    @Override
    public void saveAsPdf(Resume resume) throws UnableSavePdfException {
        try {
            String pdfName = resume.getFullName() + PDF_FILE_EXTENSION;
            String pdfContents = resume.getFullContents();

            Path filepath = Paths.get(DEFAULT_DATAPATH, pdfName);

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filepath.toString()));
            document.open();

            Paragraph contents = new Paragraph(pdfContents, DEFAULT_FONT);
            document.add(contents);
            document.close();
        } catch (FileNotFoundException | DocumentException exception) {
            throw new UnableSavePdfException();
        }
    }

}
