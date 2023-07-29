class Solution {
  public String solution(String new_id) {

        String result = new KAKAOID(new_id)
                .UptoLowerCase()
                .filter()
                .toSingleDot()
                .noStartEndDot()
                .noBlank()
                .noBiggerThan16()
                .noLessThan2()
                .getResult();

        return result;
    }

    private static class KAKAOID{
        private String s;

        KAKAOID (String s){
            this.s = s;
        }

        private KAKAOID UptoLowerCase(){ // 1단계
            s = s.toLowerCase();
            return this;
        }

        private KAKAOID filter() {
            s = s.replaceAll("[^a-z0-9._-]", "");
            return this;
        }

        private KAKAOID toSingleDot(){
            s = s.replaceAll("[.]{2,}", ".");
            return this;
        }

        private KAKAOID noStartEndDot() {
            s = s.replaceAll("^[.]|[.]$", "");
            return this;
        }

        private KAKAOID noBlank(){
            s = s.isEmpty() ? "a" : s;
            return this;
        }

        private KAKAOID noBiggerThan16() {
            if(s.length() >= 16){
                s = s.substring(0,15);
                s= s.replaceAll("[.]$", "");
            }
             
            return this;
        }

        private KAKAOID noLessThan2() {
            while(s.length() < 3){
                s += s.substring(s.length()-1,s.length());
            }
            return this;
        }

        private String getResult(){
            return s;
        }
    }
}