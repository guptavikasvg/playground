class Outside {

    private int a;

    public void foo(int b) {
        int c = a;
        int d = b;
        class Inside {
            public Inside() {
                //int e = a + b +c +d; //Cant access b,c,d - they need to be final
            }
        }
        Inside e = new Inside();
    }

}
