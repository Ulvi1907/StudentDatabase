package ga.alili.view;

import ga.alili.domain.Student;
import org.apache.poi.ss.usermodel.*;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class StudentListExcelView extends AbstractXlsView {
    @Override
    protected void buildExcelDocument(Map<String, Object> map, org.apache.poi.ss.usermodel.Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        List<Student> studentList = (List<Student>) map.get("studentList");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String file = String.format("students %s.xls", LocalDateTime.now().format(formatter));

        httpServletResponse.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\""+ file+"\"");

        Sheet sheet = workbook.createSheet("Students");

        Row header = sheet.createRow(0);
        header.setRowStyle(createHeaderStyle(workbook));
        createHeaderRow(header,workbook);
        int counter = 1;
        for (Student student : studentList)  {
            Row row = sheet.createRow(counter);
            CellStyle style = createStyle(workbook);
            row.setRowStyle(style);

            Cell id =row.createCell(0);
            id.setCellValue(student.getId());
            id.setCellStyle(style);

            Cell name = row.createCell(1);
            name.setCellValue(student.getName());
            name.setCellStyle(style);

            Cell surname = row.createCell(2);
            surname.setCellValue(student.getSurname());
            surname.setCellStyle(style);

            Cell point = row.createCell(3);
            point.setCellValue(student.getPoint());
            point.setCellStyle(style);

            counter++;
        }
        workbook.close();
        workbook.write(httpServletResponse.getOutputStream());

    }
    private CellStyle createHeaderStyle(Workbook workbook){
        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontName("Arial");
        headerFont.setColor(IndexedColors.BLUE.getIndex());
        headerFont.setFontHeight((short) 320);
        headerStyle.setFont(headerFont);
//        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
        headerStyle.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.NO_FILL);
        return headerStyle;
    }
    private CellStyle createStyle(Workbook workbook){
        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontName("Arial");
//        headerFont.setColor(IndexedColors.BLUE.getIndex());
        font.setFontHeight((short) 240);
        headerStyle.setFont(font);
//        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
//        headerStyle.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
//        headerStyle.setFillPattern(FillPatternType.NO_FILL);
        return headerStyle;
    }
    private void createHeaderRow(Row row, Workbook workbook){
        CellStyle style = createHeaderStyle(workbook);
        Cell id = row.createCell(0);
        id.setCellValue("ID");
        id.setCellStyle(style);

        Cell name = row.createCell(1);
        name.setCellValue("NAME");
        name.setCellStyle(style);

        Cell surname = row.createCell(2);
        surname.setCellValue("SURNAME");
        surname.setCellStyle(style);

        Cell point = row.createCell(3);
        point.setCellValue("POINT");
        point.setCellStyle(style);
    }
}
