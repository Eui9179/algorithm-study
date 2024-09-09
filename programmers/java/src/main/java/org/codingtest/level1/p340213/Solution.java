package org.codingtest.level1.p340213;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLenSec = convertSec(video_len);
        int posSec = convertSec(pos);
        int opStartSec = convertSec(op_start);
        int opEndSec = convertSec(op_end);

        for (String command : commands) {
            if (isOpening(posSec, opStartSec, opEndSec)) posSec = opEndSec;
            posSec = processCommand(posSec, videoLenSec, command);
        }
        if (isOpening(posSec, opStartSec, opEndSec)) posSec = opEndSec;
        return formatMS(posSec);
    }

    private boolean isOpening(int pos, int opStart, int opEnd) {
        return opStart <= pos && pos <= opEnd;
    }

    private int processCommand(int pos, int videoLen, String command) {
        if (command.equals("next")) {
            pos = next(pos, videoLen);
        } else {
            pos = prev(pos);
        }
        return pos;
    }

    private int next(int pos, int videoLen) {
        if (videoLen - pos <= 10) return videoLen;
        return pos + 10;
    }

    private int prev(int pos) {
        return Math.max(pos - 10, 0);
    }

    private String formatMS(int pos) {
        int m = pos / 60;
        int s = pos % 60;
        String mm = m < 10 ? "0" + m : String.valueOf(m);
        String ss = s < 10 ? "0" + s : String.valueOf(s);
        return mm + ":" + ss;
    }

    private int convertSec(String time) {
        String[] timeArr = time.split(":");
        return (Integer.parseInt(timeArr[0]) * 60) + Integer.parseInt(timeArr[1]);
    }


}
