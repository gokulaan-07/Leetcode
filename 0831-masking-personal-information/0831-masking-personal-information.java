class Solution {
    public String maskPII(String s) {
        StringBuilder builder = new StringBuilder();
        int n = s.length();
        if (s.indexOf('@') != -1) {
            boolean domainReached = false, lastCharCaptured = false;
            char lastChar = '*';
            for (int i = n - 1; i >= 0; --i) {
                char ch = s.charAt(i);
                if (ch == '@') {
                    builder.append(ch);
                    domainReached = true;
                    continue;
                }
                if (isValidMail(ch)) {
                    if (isUp(ch)) ch = (char)(ch + 32);
                    if (!domainReached) builder.append(ch);
                    else {
                        if (!lastCharCaptured) {
                            lastCharCaptured = true;
                            builder.append(ch);
                        } else lastChar = ch;
                    }
                }
            }
            builder.append("*****");
            builder.append(lastChar);
        } else {
            boolean masking = false;
            for (int i = n - 1, count = 0, groupLen = 0; i >= 0; --i) {
                char ch = s.charAt(i);
                if (isValidNum(ch)) {
                    if (count == 4) {
                        builder.append('-');
                        masking = true;
                        groupLen = 0;
                    } else if (count > 4 && groupLen == 3) {
                        builder.append('-');
                        groupLen = 0;
                    }
                    builder.append(!masking ? ch : '*');
                    ++count;
                    ++groupLen;
                }
            }
            if (builder.length() > 12) builder.append('+');
        }
        return builder.reverse().toString();
    }

    private boolean isValidMail(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '.') return true;
        return false;
    }
    private boolean isUp(char c) {
        if (c >= 'A' && c <= 'Z') return true;
        return false;
    } 
    private boolean isValidNum(char c) {
        if (c >= '0' && c <= '9') return true;
        return false;
    }
}