package com.isoftstone.kaoqin.common.utils;

import com.isoftstone.kaoqin.bean.attendance.Attendance;
import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.common.constants.AttendanceConstants;
import com.isoftstone.kaoqin.controller.vo.AttendVo;
import com.isoftstone.kaoqin.controller.vo.AttendanceDateVo;
import org.apache.poi.hssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by wb-chenchaobin on 2015/9/23.
 */
public class CreateExcelToDisk {
    /**
     * @功能：手工构建一个简单格式的Excel
     */


    public static BasicAttendance getExcel(List<AttendVo> listvo,AttendanceDateVo dateVo) throws Exception{

        BasicAttendance basicAttendance = new BasicAttendance();
        /**列数*/
        List<String>dateList = dateVo.getDateList();
        int colNum = dateList.size();

        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("考勤表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        HSSFCell cell = row.createCell((short) 0);
        cell.setCellValue("序号");
        cell.setCellStyle(style);
        cell = row.createCell((short) 1);
        cell.setCellValue("姓名");
        cell.setCellStyle(style);
        cell = row.createCell((short) 2);
        cell.setCellValue("实际项目");
        cell.setCellStyle(style);
        for(int i= 0 ;i<colNum ;i++){
            String dateNum = dateList.get(i);
            cell = row.createCell((short) (i+3));
            cell.setCellValue(dateNum);
            cell.setCellStyle(style);
        }

        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
        try{
        for (int i = 0; i < listvo.size(); i++){
            row = sheet.createRow(i + 1);
            AttendVo attendVo =  listvo.get(i);
            List<Attendance> attendanceList = attendVo.getAttendanceList();
            // 第四步，创建单元格，并设置值
            row.createCell((short) 0).setCellValue(i+1);
            row.createCell((short) 1).setCellValue(attendVo.getRealName());
            row.createCell((short) 2).setCellValue(attendVo.getProjectName());
            for(int j= 0 ;j<colNum ;j++){
                Attendance attendance = attendanceList.get(j);
                row.createCell((short)(j+3)).setCellValue(attendance.getDescription());
            }
        }
        // 第六步，将文件存到指定位置

            File file = new File("C:\\Users\\wb-chenchaobin\\Desktop\\考勤表.xls");
            if(file.exists()){file.delete();}
            FileOutputStream fout = new FileOutputStream(file);
            wb.write(fout);
            fout.close();
            basicAttendance.setMsg(AttendanceConstants.createExcelSuccessMsg);
            basicAttendance.setCode(AttendanceConstants.createExcelSuccessCode);
            return basicAttendance;
        }
        catch (Exception e){
            e.printStackTrace();
            basicAttendance.setMsg(AttendanceConstants.createExcelFailedMsg);
            basicAttendance.setCode(AttendanceConstants.createExcelFailedCode);
            return basicAttendance;
        }
    }

}
