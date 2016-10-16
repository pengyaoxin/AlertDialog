package cn.edu.gdmec.s07150738.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    private TextView tView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tView = (TextView)this.findViewById(R.id.textView);
        Button button1 = (Button)this.findViewById(R.id.button1);
        Button button2 = (Button)this.findViewById(R.id.button2);
        Button button3 = (Button)this.findViewById(R.id.button3);
        Button button4 = (Button)this.findViewById(R.id.button4);
        Button button5 = (Button)this.findViewById(R.id.button5);
        Button button6 = (Button)this.findViewById(R.id.button6);
        Button button7 = (Button)this.findViewById(R.id.button7);
        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }
            }
        };
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
    }

    public void dialog1(){
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("两个按钮");
        dialog.setMessage("确定退出吗?");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);

        DialogInterface.OnClickListener lis1 = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which==DialogInterface.BUTTON_POSITIVE){
                    dialog.dismiss();
                    finish();
                }else if (which==DialogInterface.BUTTON_NEGATIVE){
                    dialog.dismiss();
                }
            }
        };

        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis1);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",lis1);
        dialog.show();
    }

    private void dialog2(){
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("三个按钮");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        dialog.setMessage("杜甫忙吗?");

        DialogInterface.OnClickListener lis2 = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="杜甫";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str = str + "很忙";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str = str + "不忙";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str = str + "一般般";
                        break;
                }
            }
        };

        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"忙啊",lis2);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"闲啊",lis2);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"一般般",lis2);
        dialog.show();
    }

    private void dialog3(){
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("请输入");
        dialog.setMessage("你平时忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        final EditText tEdit = new EditText(this);
        dialog.setView(tEdit);

        //创建按键监听器
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tView.setText("输入的是："+tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }

    private void dialog4(){

        final String item[] = new String[]{"北京","上海","广州"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener lis4 = new DialogInterface.OnMultiChoiceClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                //用一个数组记录下选择的所有选项
                bSelect[which] = isChecked;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,bSelect,lis4);
        dialog = builder.create();
        dialog.setTitle("多选框");
        DialogInterface.OnClickListener lis41 = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    String str ="你选择了：";
                    for (int i=0;i<bSelect.length;i++){
                        if (bSelect[i]){
                            str=str+"\n"+item[i];
                        }
                    }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"确定",lis41);
        dialog.show();
    }

    private void dialog5(){
        final String item[] = new String[]{"北京","上海","广州"};
        final boolean bSelect[] =new boolean[item.length];
        DialogInterface.OnClickListener lis5 = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for (int i=0;i<item.length;i++){
                    if (i==which){
                       bSelect[i]=true;
                    }else{
                        bSelect[i]=false;
                    }
                }
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,lis5);
        dialog = builder.create();
        dialog.setTitle("单选框");
        DialogInterface.OnClickListener lis51 = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了：";
                for (int i=0;i<bSelect.length;i++){
                    if (bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis51);
        dialog.show();

    }

    private void dialog6(){
        final String item[] = new String[]{"北京","上海","广州"};
        DialogInterface.OnClickListener lis6 = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tView.setText(item[which]);
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setItems(item,lis6);
        dialog = builder.create();
        dialog.setTitle("列表");

        DialogInterface.OnClickListener lis61 = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };

        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"确定",lis61);
        dialog.show();
    }

    private void dialog7(){
        LayoutInflater lf = getLayoutInflater();
        View layout = lf.inflate(R.layout.layout,null);
        final EditText et1 =(EditText) layout.findViewById(R.id.editText);

        dialog = new AlertDialog.Builder(this).create();
        dialog.setView(layout);

        DialogInterface.OnClickListener lis7 = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tView.setText("你输入的是"+et1.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis7);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",lis7);
        dialog.show();
    }
}
