package main.java.twostacksusingarray;

class CheckTwoStacks {
    public static void main(String args[]) {
        String[][] calls = {
                {"TwoStacks", "push1", "push2", "pop2"},
                {"TwoStacks", "push1", "pop1", "push2", "pop2"},
                {"TwoStacks", "push1", "push2", "push1", "push2", "pop1", "pop2", "pop1"},
                {"TwoStacks", "push2", "pop2", "push2", "push1"},
                {"TwoStacks", "push1", "push1", "push2", "pop1"},
        };

        Integer[][] inputs = {
                {5, 10, 15, null},
                {7, -4, null, -6, null},
                {5, 10, 20, 50, 30, null, null, null},
                {10, 4, null, 8, 10},
                {3, 10, 20, 30, null},
        };

        for (int i = 0; i < calls.length; i++) {
            System.out.println("Testcase " + (i + 1) + ":");
            TwoStacks<Integer> stackObj = new TwoStacks<>(inputs[i][0]);

            for (int j = 1; j < calls[i].length; j++) {
                switch (calls[i][j]) {
                    case "push1":
                        stackObj.push1(inputs[i][j]);
                        break;
                    case "push2":
                        stackObj.push2(inputs[i][j]);
                        break;
                    case "pop1":
                        System.out.println("\tpop1 returns " + stackObj.pop1());
                        break;
                    case "pop2":
                        System.out.println("\tpop2 returns " + stackObj.pop2());
                        break;
                }
            }
            System.out.println(new String(new char[75]).replace('\0', '-'));
        }
    }
}
