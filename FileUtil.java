import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public  class  FileUtil  {  
 
   /**  
     *  新建目录  
     *  @param  folderPath  String  如  c:/fqf  
     *  @return  boolean  
     */  
   public static  boolean  newFolder(String folderPath)  {   
       File  myFolderPath  =  new  File(folderPath);   
       if  (!myFolderPath.exists())  { 
           String parentFolderPath=myFolderPath.getParent();            
           File parentFolder=new File(parentFolderPath);
           if(!parentFolder.exists()){
               newFolder(parentFolderPath);
           }            
           myFolderPath.mkdir();  
       }
       return myFolderPath.exists();//返回是否创建成功
   }
   
   /**  
    *  新建文件  
    *  @param  filePath  String  文件路径及名称  如c:/fqf.txt  
    *  @return  boolean  
    */  
   public static boolean newFile(String  filePath)  {        
       File  myFilePath  =  new  File(filePath);  
       try  {  
           if  (!myFilePath.exists())  { 
               String parentFolderPath=myFilePath.getParent();
               File parentFolder=new File(parentFolderPath);
               if(!parentFolder.exists()){
                   newFolder(parentFolderPath);
               }
               if  (!myFilePath.exists())  {  
                   myFilePath.createNewFile();  
               } 
           }
       } catch(IOException e)  {  
           System.out.println("新建目录操作出错");  
           e.printStackTrace();  
       }
       return myFilePath.exists();//返回是否创建成功           
   }
   
   /**  
    *  删除文件  
    *  @param  filePathAndName  String  文件路径及名称  如c:/fqf.txt  
    *  @param  fileContent  String  
    *  @return  boolean  
    */  
   public static boolean  delFile(String  filePath)  {  
           java.io.File  myDelFile  =  new  java.io.File(filePath);  
           return myDelFile.delete();  
   }  
  
  /**  
   *  删除文件夹  
   *  @param  filePathAndName  String  文件夹路径及名称  如c:/fqf  
   *  @param  fileContent  String  
   *  @return  boolean  
   */  
   public  static void  delFolder(String  folderPath)  {  
       try{  
           delAllFile(folderPath);  //删除完里面所有内容   
           java.io.File  myFilePath  =  new  java.io.File(folderPath);  
           myFilePath.delete();  //删除空文件夹  
       }  
       catch  (Exception  e)  {  
           System.out.println("删除文件夹操作出错");  
           e.printStackTrace();  
       }      
   }      
 
   /**  
    *  删除文件夹里面的所有文件  
    *  @param  path  String  文件夹路径  如  c:/fqf  
    */  
 
   public static void  delAllFile(String  path)  {  
       File  file  =  new  File(path);  
       if  (!file.exists())  {  
           return;  
       }  
       if  (!file.isDirectory())  {  
           return;  
       }  
       String[]  tempList  =  file.list();  
       File  temp  =  null;  
       for  (int  i  =  0;  i  <  tempList.length;  i++)  {  
           if  (path.endsWith(File.separator))  {  
               temp  =  new  File(path  +  tempList[i]);  
           }  
           else  {  
               temp  =  new  File(path  +  File.separator  +  tempList[i]);  
           }  
           if  (temp.isFile())  {  
               temp.delete();  
           }  
           if  (temp.isDirectory())  {  
               delAllFile(path+"/"+  tempList[i]);//先删除文件夹里面的文件  
               delFolder(path+"/"+  tempList[i]);//再删除空文件夹  
           }  
       }  
   } 

    /**  
     *  复制单个文件  
     *  @param  oldPath  String  原文件路径  如：c:/fqf.txt  
     *  @param  newPath  String  复制后路径  如：f:/fqf.txt 如果是文件夹就复制到这个文件夹下 
     *  @return  boolean  
     */  
    public  static void  copyFile(String  oldPath,  String  newPath)  {  
       try  {  
           int  byteread  =  0;  
           File  oldfile  =  new  File(oldPath);  
           File  newFile  =  new  File(newPath);
           if(newFile.isDirectory()){
               if(!newFile.exists()){
                   newFolder(newFile.getAbsolutePath());
               }
               newFile=new File(newFile.getAbsoluteFile()+File.separator+oldfile.getName());
           }        
           if  (oldfile.exists())  {  //文件存在时  
               InputStream  inStream  =  new  FileInputStream(oldPath);  //读入原文件 
               FileOutputStream  fs  =  new  FileOutputStream(newFile);  
               byte[]  buffer  =  new  byte[1444];  
               while  (  (byteread  =  inStream.read(buffer))  !=  -1)  {  
                   fs.write(buffer,  0,  byteread);  
               }  
               inStream.close();  
           }  
       }  
       catch  (Exception  e)  {  
           System.out.println("复制单个文件操作出错");  
           e.printStackTrace();  
       }  
    }  

    /**  
     *  复制整个文件夹内容  
     *  @param  oldPath  String  原文件路径  如：c:/fqf  
     *  @param  newPath  String  复制后路径  如：f:/fqf/ff  
     *  @return  boolean  
     */  
    public  void  copyFolder(String  oldPath,  String  newPath)  {  
    
       try  {  
           (new  File(newPath)).mkdirs();  //如果文件夹不存在  则建立新文件夹  
           File  a=new  File(oldPath);  
           String[]  file=a.list();  
           File  temp=null;  
           for  (int  i  =  0;  i  <  file.length;  i++)  {  
               if(oldPath.endsWith(File.separator)){  
                   temp=new  File(oldPath+file[i]);  
               }  
               else{  
                   temp=new  File(oldPath+File.separator+file[i]);  
               }  
    
               if(temp.isFile()){  
                   FileInputStream  input  =  new  FileInputStream(temp);  
                   FileOutputStream  output  =  new  FileOutputStream(newPath  +  "/"  + 
                           (temp.getName()).toString());  
                   byte[]  b  =  new  byte[1024  *  5];  
                   int  len;  
                   while  (  (len  =  input.read(b))  !=  -1)  {  
                       output.write(b,  0,  len);  
                   }  
                   output.flush();  
                   output.close();  
                   input.close();  
               }  
               if(temp.isDirectory()){//如果是子文件夹  
                   copyFolder(oldPath+"/"+file[i],newPath+"/"+file[i]);  
               }  
           }  
       }  
       catch  (Exception  e)  {  
           System.out.println("复制整个文件夹内容操作出错");  
           e.printStackTrace();  
    
       }  
    
    }  

    /**  
     *  移动文件到指定目录  
     *  @param  oldPath  String  如：c:/fqf.txt  
     *  @param  newPath  String  如：d:/fqf.txt  
     */  
    public  void  moveFile(String  oldPath,  String  newPath)  {  
       copyFile(oldPath,  newPath);  
       delFile(oldPath);     
    } 
    
    /**  
     *  移动文件到指定目录  
     *  @param  oldPath  String  如：c:/fqf.txt  
     *  @param  newPath  String  如：d:/fqf.txt  
     */  
    public  void  moveFolder(String  oldPath,  String  newPath)  {  
       copyFolder(oldPath,  newPath);  
       delFolder(oldPath);  
    }  

    public static ArrayList<File> allFilesInForder(String path,boolean isRecersive) throws FileNotFoundException {
        File file = new File(path);
        ArrayList<File> list = new ArrayList<File>();
        
        if (!file.exists()) { 
            System.out.println("文件不存在!");
            throw new FileNotFoundException("文件不存在!");
        }else{
            File[] files = file.listFiles();
            for(File f:files){
                list.add(f);
            }       
            if(!isRecersive){
                 return list;     
            }else{
                Stack<File> dirStack=new Stack<File>();
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        dirStack.push(file2);
                    }
                }
                while(!dirStack.isEmpty()){
                    list.addAll(allFilesInForder(dirStack.pop().getAbsolutePath(), isRecersive));
                }
            }
           return list;
        }
    }     

}
