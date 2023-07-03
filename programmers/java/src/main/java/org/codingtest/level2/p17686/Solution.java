package org.codingtest.level2.p17686;

import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        FileInfo[] fileInfos = new FileInfo[files.length];

        for (int i = 0; i < files.length; i++) {
            fileInfos[i] = new FileInfo(files[i]);
        }

        Arrays.sort(fileInfos);

        return Arrays.stream(fileInfos)
                .map(file -> file.originName)
                .toArray(String[]::new);
    }

    public static class FileInfo implements Comparable<FileInfo> {
        String originName;
        String head;
        int number;
        String tail;

        FileInfo(String file) {
            this.originName = file;
            String[] strs = file.toLowerCase().split("");
            int[] numberIndex = getNumberIndex(strs);

            this.head = getHead(strs, numberIndex[0]);
            this.number = getNumber(strs, numberIndex[0]);
            this.tail = getTail(strs, numberIndex[1]);
        }

        @Override
        public int compareTo(FileInfo fileInfo) {
            int comp1 = this.head.compareTo(fileInfo.head);
            if (comp1 != 0) return comp1;
            return this.number - fileInfo.number;
        }

        private int[] getNumberIndex(String[] strs) {
            boolean pro = false;
            int start = 0;
            int end = 0;
            for (int i = 0; i < strs.length; i++) {
                if (!isNumberic(strs[i])) {
                    if (pro) {
                        end = i;
                        break;
                    }
                }
                else {
                    if (!pro) start = i;
                    pro = true;
                }
            }
            return new int[] {start, end};
        }

        private int getNumber(String[] strs, int numberIndex) {
            StringBuilder result = new StringBuilder();
            for (int i = numberIndex; i < strs.length; i++) {
                if (!isNumberic(strs[i])) break;
                result.append(strs[i]);
            }
            return Integer.parseInt(result.toString());
        }

        private String getHead(String[] strs, int numberIndex) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < numberIndex; i++) {
                result.append(strs[i]);
            }
            return result.toString();
        }

        private String getTail(String[] strs, int numberEndIndex) {
            StringBuilder result = new StringBuilder();
            for (int i = numberEndIndex; i < strs.length; i++) {
                result.append(strs[i]);
            }
            return result.toString();
        }

        private boolean isNumberic(String str) {
            try {
                Integer.parseInt(str);
                return true;
            } catch(NumberFormatException e) {
                return false;
            }
        }
    }
}
