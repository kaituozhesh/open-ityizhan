package com.open.ityizhan.rebuild.example02;

/**
 * @Description:
 * @ClassName: Demo04
 * @Auther: lin
 * @Date: 2024/8/5 14:22
 * @Version: 1.0
 */
public class Demo04 {

    class Account {
        int delta() {
            return 1;
        }

        int gamma(int inputVal, int quantity, int yearToDate) {
            int importantValue1 = (inputVal * quantity) + delta();
            int importantValue2 = (inputVal * yearToDate) + 100;
            if ((yearToDate - importantValue1) > 100) {
                importantValue2 -= 20;
            }
            int importantValue3 = importantValue2 * 7;
            return importantValue3 - 2 * importantValue1;
        }
    }

    class Gamma {
        private final Account account;
        private int inputVal;
        private int quantity;
        private int yearToDate;
        private int importantValue1;
        private int importantValue2;
        private int importantValue3;

        public Gamma(Account account, int inputVal, int quantity, int yearToDate) {
            this.account = account;
            this.inputVal = inputVal;
            this.quantity = quantity;
            this.yearToDate = yearToDate;
        }

        int compute() {
            int importantValue1 = (inputVal * quantity) + account.delta();
            int importantValue2 = (inputVal * yearToDate) + 100;
            importantThing();
            int importantValue3 = importantValue2 * 7;
            return importantValue3 - 2 * importantValue1;
        }

        void importantThing() {
            if ((yearToDate - importantValue1) > 100) {
                importantValue2 -= 20;
            }
        }
    }
}
