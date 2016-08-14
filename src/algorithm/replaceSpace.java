public class Solution {
    public String replaceSpace(StringBuffer str) {
    	char[]s = str.toString().toCharArray();
        int spaceCnt = 0;
        for(int i = 0; i<s.length;i++)
        {
            if(s[i]==' ') spaceCnt++;
        }
        
        char[]rStr = new char[s.length+spaceCnt*2];
        for(int i=0,j=0; i<s.length; i++)
        {
            if(s[i]==' ')
            {
                rStr[j] = '%';
                rStr[++j] = '2';
                rStr[++j] = '0';
                ++j;
            }
           	else
            {
                rStr[j] = s[i];
                j++;
            }
        }
        return new String(rStr);
    }
}