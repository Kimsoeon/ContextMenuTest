package soeonkim.kr.hs.emirim.contextmenutest;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;
    Button but2; //전역변수로 사용하기 위해서 필드로 옮김(메소드 밖) 회전하려면 다른 메소드에서도 써야하니까
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but1 = (Button) findViewById(R.id.but1);
        but2 = (Button) findViewById(R.id.but2);
        linear = (LinearLayout) findViewById(R.id.linear);
        img = (ImageView) findViewById(R.id.img1);
        registerForContextMenu(but1);
        registerForContextMenu(but2);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        if (v.getId() == R.id.but1) {
            menu.setHeaderTitle("배경색 변경");
            menu.setHeaderIcon(R.drawable.dog);
            menuInflater.inflate(R.menu.menu1, menu); //컨텍스트 메뉴 생성
        }
        if (v.getId() == R.id.but2) {
            menuInflater.inflate(R.menu.menu2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId()) {
            case R.id.menu1_item_red:
                linear.setBackgroundColor(Color.RED);
                return true;
            case R.id.menu1_item_green:
                linear.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.menu1_item_blue:
                linear.setBackgroundColor(Color.BLUE);
                //Color.argb 알파값사용해서 색상 만들어줌
                //Color.rgb하면 핑크색 이런것도 가능
                return true;
            case R.id.menu2_item_rotation:
                img.setRotation(img.getRotation()+45);
                return true;
            case R.id.menu2_item_size_small:
                img.setScaleX(img.getScaleX()*0.7f);
                img.setScaleY(img.getScaleY()*0.7f);
                return true;
            case R.id.menu2_item_size_big:
                img.setScaleX(img.getScaleX()*1.5f);
                img.setScaleY(img.getScaleY()*1.5f);
                return true;

        }
        return false;
    }

}