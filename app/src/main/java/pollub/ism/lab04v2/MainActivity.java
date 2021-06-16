package pollub.ism.lab04v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    char[] plansza = new char[9];
    int[] blokada ={0,0,0,0,0,0,0,0,0};
    int[] blk ={0,0,0,0,0,0,0,0,0};
    int gracz=1;
    int koniec_gry=0;
    int flaga=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            gracz=savedInstanceState.getInt("klucz");
            blokada=savedInstanceState.getIntArray("klucz2");
            blk=savedInstanceState.getIntArray("klucz3");
            koniec_gry=savedInstanceState.getInt("klucz4");
            flaga=savedInstanceState.getInt("klucz5");
        }

        if(blokada[0]==1){
            ((Button)findViewById(R.id.button1)).setText("X");
        }
        if(blokada[0]==2){
            ((Button)findViewById(R.id.button1)).setText("O");
        }
        if(blokada[1]==1){
            ((Button)findViewById(R.id.button2)).setText("X");
        }
        if(blokada[1]==2){
            ((Button)findViewById(R.id.button2)).setText("O");
        }
        if(blokada[2]==1){
            ((Button)findViewById(R.id.button3)).setText("X");
        }
        if(blokada[2]==2){
            ((Button)findViewById(R.id.button3)).setText("O");
        }
        if(blokada[3]==1){
            ((Button)findViewById(R.id.button4)).setText("X");
        }
        if(blokada[3]==2){
            ((Button)findViewById(R.id.button4)).setText("O");
        }
        if(blokada[4]==1){
            ((Button)findViewById(R.id.button5)).setText("X");
        }
        if(blokada[4]==2){
            ((Button)findViewById(R.id.button5)).setText("O");
        }
        if(blokada[5]==1){
            ((Button)findViewById(R.id.button6)).setText("X");
        }
        if(blokada[5]==2) {
            ((Button)findViewById(R.id.button6)).setText("O");
        }
        if(blokada[6]==1){
            ((Button)findViewById(R.id.button7)).setText("X");
        }
        if(blokada[6]==2){
            ((Button)findViewById(R.id.button7)).setText("O");
        }
        if(blokada[7]==1){
            ((Button)findViewById(R.id.button8)).setText("X");
        }
        if(blokada[7]==2){
            ((Button)findViewById(R.id.button8)).setText("O");
        }
        if(blokada[8]==1){
            ((Button)findViewById(R.id.button9)).setText("X");
        }
        if(blokada[8]==2) {
            ((Button)findViewById(R.id.button9)).setText("O");
        }
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("klucz",gracz);
        savedInstanceState.putIntArray("klucz2",blokada);
        savedInstanceState.putIntArray("klucz3",blk);
        savedInstanceState.putInt("klucz4",koniec_gry);
        savedInstanceState.putInt("klucz5",flaga);
    }

    public void kliknieciePrzycisku(View view){
        flaga=1;
        int pozwolenie=1;
        for(int j=0; j<9; j++)
            if(blk[j]==view.getId()){
                pozwolenie=0;
            }

        if(pozwolenie==1&&koniec_gry==0)
        switch (view.getId()) {
            case R.id.button1:
                blokada[0]=gracz;
                blk[0]=view.getId();
                break;
            case R.id.button2:
                blokada[1]=gracz;
                blk[1]=view.getId();
                break;
            case R.id.button3:
                blokada[2]=gracz;
                blk[2]=view.getId();
                break;
            case R.id.button4:
                blokada[3]=gracz;
                blk[3]=view.getId();
                break;
            case R.id.button5:
                blokada[4]=gracz;
                blk[4]=view.getId();
                break;
            case R.id.button6:
                blokada[5]=gracz;
                blk[5]=view.getId();
                break;
            case R.id.button7:
                blokada[6]=gracz;
                blk[6]=view.getId();
                break;
            case R.id.button8:
                blokada[7]=gracz;
                blk[7]=view.getId();
                break;
            case R.id.button9:
                blokada[8]=gracz;
                blk[8]=view.getId();
                break;
        }
        if(pozwolenie==1&&koniec_gry==0){
            if(gracz==1){
                ((Button)findViewById(view.getId())).setText("X");
                gracz=2;
            }else{
                ((Button)findViewById(view.getId())).setText("O");
                gracz=1;
            }
        }
        if(koniec_gry==0)
        wynik(view);
    }

    public void wynik(View view){

        CharSequence p1=((Button)findViewById(R.id.button1)).getText();
        CharSequence p2=((Button)findViewById(R.id.button2)).getText();
        CharSequence p3=((Button)findViewById(R.id.button3)).getText();
        CharSequence p4=((Button)findViewById(R.id.button4)).getText();
        CharSequence p5=((Button)findViewById(R.id.button5)).getText();
        CharSequence p6=((Button)findViewById(R.id.button6)).getText();
        CharSequence p7=((Button)findViewById(R.id.button7)).getText();
        CharSequence p8=((Button)findViewById(R.id.button8)).getText();
        CharSequence p9=((Button)findViewById(R.id.button9)).getText();

        String tmp="Wygrał gracz ";

        if(p1==p2&&p2==p3&&p1!=""&&p2!=""&&p3!=""){
            Toast.makeText(this, tmp+p1, Toast.LENGTH_LONG).show();
            koniec_gry=1;
        }
        if(p4==p5&&p5==p6&&p4!=""&&p5!=""&&p6!="") {
            Toast.makeText(this, tmp + p4, Toast.LENGTH_LONG).show();
            koniec_gry=1;
        }
        if(p7==p8&&p8==p9&&p7!=""&&p8!=""&&p9!=""){
            Toast.makeText(this, tmp+p7, Toast.LENGTH_LONG).show();
            koniec_gry=1;
        }
        if(p1==p4&&p4==p7&&p1!=""&&p4!=""&&p7!=""){
            Toast.makeText(this, tmp+p1, Toast.LENGTH_LONG).show();
            koniec_gry=1;
        }
        if(p2==p5&&p5==p8&&p2!=""&&p5!=""&&p8!=""){
            Toast.makeText(this, tmp+p2, Toast.LENGTH_LONG).show();
            koniec_gry=1;
        }
        if(p3==p6&&p6==p9&&p3!=""&&p6!=""&&p9!=""){
            Toast.makeText(this, tmp+p3, Toast.LENGTH_LONG).show();
            koniec_gry=1;
        }
        if(p1==p5&&p5==p9&&p1!=""&&p5!=""&&p9!=""){
            Toast.makeText(this, tmp+p1, Toast.LENGTH_LONG).show();
            koniec_gry=1;
        }
        if(p3==p5&&p5==p7&&p3!=""&&p5!=""&&p7!=""){
            Toast.makeText(this, tmp+p3, Toast.LENGTH_LONG).show();
            koniec_gry=1;
        }

        int tmp2=1, i;

        if(flaga==1&&koniec_gry==0){
            for(i=0; i<9; i++){
                if (blokada[i] == 0) {
                    tmp2 = 0;
                }
            }
            if(tmp2==1){
                Toast.makeText(this, "Nikt nie wygrał!", Toast.LENGTH_LONG).show();
            }
        }

        tmp2=1;
        if(flaga==0&&koniec_gry==0) {
            for (i = 0; i < 9; i++) {
                if (blokada[i] == 0) {
                    tmp2 = 0;
                }
            }
            if(tmp2==1){
                Toast.makeText(this, "Nikt nie wygrał!", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this, "Graj dalej!", Toast.LENGTH_LONG).show();
            }
        }else{

        }


        if(flaga==1)
            flaga=0;
    }

    public void reset(View view){
        Toast.makeText(this,"Czyszczenie", Toast.LENGTH_LONG).show();
        for(int i=0; i<9; i++)
        {
            blokada[i]=0;
            blk[i]=0;
            koniec_gry=0;
        }

        ((Button)findViewById(R.id.button1)).setText("");
        ((Button)findViewById(R.id.button2)).setText("");
        ((Button)findViewById(R.id.button3)).setText("");
        ((Button)findViewById(R.id.button4)).setText("");
        ((Button)findViewById(R.id.button5)).setText("");
        ((Button)findViewById(R.id.button6)).setText("");
        ((Button)findViewById(R.id.button7)).setText("");
        ((Button)findViewById(R.id.button8)).setText("");
        ((Button)findViewById(R.id.button9)).setText("");

    }
}