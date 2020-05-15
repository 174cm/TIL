/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

/**
 *
 * @author MASTER
 */
public class FileListBean {

    private String dirName;
    private List<String> relativeFileList = new ArrayList<String>();
    private List<String> absoluteFileList = new ArrayList<String>();

    public FileListBean() {

    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
        readDirectory();
    }

    public List<String> getRelativeFileList() {
        return relativeFileList;
    }

    public List<String> getAbsoluteFileList() {
        return absoluteFileList;
    }

    private void readDirectory() {
        File dir = new File(dirName);

        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File f : files) {
                relativeFileList.add(f.getName());
                absoluteFileList.add(f.getAbsolutePath());
            }
        }
    }
}
