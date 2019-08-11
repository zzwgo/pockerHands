package com.my;

public class Pocker {
    private int point;
    private PockerColor pockerColor;
    private static final int TYPE_J = 11;
    private static final int TYPE_Q = 12;
    private static final int TYPE_K  = 13;
    private static final int TYPE_A  = 14;
    public int getPoint() {
        return point;
    }
    public String  getPockerColor() {
        return pockerColor.getColor();
    }
    public Pocker(String pockerCard) {
        if(pockerCard.contains("10")){
            this.setPoint(10);
            this.chooseColor(pockerCard.charAt(pockerCard.length()-1));
        }else {
            this.choosepoint(pockerCard.charAt(0));
            this.chooseColor(pockerCard.charAt(1));
        }
    }
    protected void setPoint(int point) {
        this.point = point;
    }

    protected void setPockerColor(PockerColor pockerColor) {
        this.pockerColor = pockerColor;
    }

    protected void chooseColor(char color){
        switch (color){
            case 'C':
                this.setPockerColor(PockerColor.CLUB);
                break;
            case 'S':
                this.setPockerColor(PockerColor.SPADE);
                break;
            case 'H':
                this.setPockerColor(PockerColor.HEART);
                break;
            case 'D':
                this.setPockerColor(PockerColor.DIAMOND);
                break;
        }
    }
    protected void choosepoint(char point){
        switch (point){
            case 'J':
                this.setPoint(TYPE_J);
                break;
            case 'Q':
                this.setPoint(TYPE_Q);
                break;
            case 'K':
                this.setPoint(TYPE_K);
                break;
            case 'A':
                this.setPoint(TYPE_A);
                break;
            default:
                this.setPoint(Integer.parseInt(String.valueOf(point)));
                break;
        }
    }
}
