public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        
        int len = bowlingCode.length();//字符串长度
        int scores = 0;
        int[] score = new int[12]; 
        int[] ewai = new int[10];
        int[] bottles = new int[24];
        int t = 0;//格数
        
        for(int i = 0; i < 12; i ++)
            score[i] = 0;
        for(int i = 0; i < 10; i ++)
            ewai[i] = 0;
        for(int i = 0; i < 22; i ++)
            bottles[i] = -1;
        
        for(int i = 0; i < len; i ++) {
            switch(bowlingCode.charAt(i)) {
                case '|':
                    if(t<10)
                        t += 1;
                    else {
                        //bowlingCode.charAt(i)
                        for(int j = 0; j < ewai[9]; j ++, i ++) {
                            if(bowlingCode.charAt(i+j+2) == 'X')
                                bottles[20+j] = 10;
                            else
                                bottles[20+j] = bowlingCode.charAt(i+j+2) - '0';
                        }
                    }
                    break;
                case 'X':
                    score[t] = 10;
                    bottles[t*2] = 10;
                    ewai[t] = 2;
                    break;
                case '/':
                    score[t] = 10;
                    ewai[t] = 1;
                    bottles[t*2+1] = 10 - bottles[t*2];
                    break;
                case '-':
                    if(bottles[t*2] != -1)
                        bottles[t*2+1] = 0;
                    else
                        bottles[t*2] = 0;
                    break;
                default:
                    score[t] += bowlingCode.charAt(i) - '0';
                    if(bottles[t*2] != -1)
                        bottles[t*2+1] = bowlingCode.charAt(i) - '0';
                    else
                        bottles[t*2] = bowlingCode.charAt(i) - '0';
                    break;
            }
        }

        for(int i = 0; i < 10; i ++){
            if(ewai[i] == 0){
                    scores += score[i];
                    continue;
            }
            else {
                scores += score[i];
                    //int k = 0;
                for(int j = 0, k = 0; j < ewai[i]; k ++) {
                    if(bottles[i*2+2+k] != 0) {
                        scores += bottles[i*2+2+k];
                        j ++;
                    }
                }
            }
        }
                       
        
        return scores;
    }
}
