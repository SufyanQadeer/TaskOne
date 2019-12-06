package wapda.billchecker.taskone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private EditText etSearch;
    private ListView lvProducts;
    public  ArrayList<Product> mProductArrayList = new ArrayList<Product>();
    private MyAdapter adapter1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initialize();



        // Add Text Change Listener to EditText
        etSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Call back the Adapter with current character to Filter
                adapter1.getFilter().filter(s.toString());

                lvProducts.invalidateViews();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void initialize()

    {
        etSearch = (EditText) findViewById(R.id.etSearch);
        lvProducts = (ListView)findViewById(R.id.lvProducts);
    }



    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        mProductArrayList.add(new Product(0,"sufyan"));
        mProductArrayList.add(new Product(1,"sadda"));
        mProductArrayList.add(new Product(2,"hassan"));
        mProductArrayList.add(new Product(3,"ali"));
        mProductArrayList.add(new Product(4,"sadda"));
        mProductArrayList.add(new Product(5,"ali"));
        mProductArrayList.add(new Product(6,"hassan"));
        mProductArrayList.add(new Product(7,"arslan"));
        mProductArrayList.add(new Product(8,"khan"));
        mProductArrayList.add(new Product(9,"software"));
        mProductArrayList.add(new Product(10,"c"));
        mProductArrayList.add(new Product(11,"d"));
        mProductArrayList.add(new Product(12,"c"));
        mProductArrayList.add(new Product(13,"d"));
        mProductArrayList.add(new Product(14,"sufyan"));
        mProductArrayList.add(new Product(15,"sadda"));
        mProductArrayList.add(new Product(16,"hassan"));
        mProductArrayList.add(new Product(17,"ali"));
        mProductArrayList.add(new Product(18,"sadda"));
        mProductArrayList.add(new Product(19,"ali"));
        mProductArrayList.add(new Product(20,"hassan"));
        mProductArrayList.add(new Product(21,"arslan"));
        mProductArrayList.add(new Product(22,"khan"));
        mProductArrayList.add(new Product(23,"software"));
        mProductArrayList.add(new Product(24,"software"));
        mProductArrayList.add(new Product(25,"software"));
        mProductArrayList.add(new Product(26,"software"));
        mProductArrayList.add(new Product(27,"software"));
        mProductArrayList.add(new Product(28,"software"));
        mProductArrayList.add(new Product(29,"software"));
        mProductArrayList.add(new Product(30,"software"));
        mProductArrayList.add(new Product(31,"software"));
        mProductArrayList.add(new Product(32,"software"));
        mProductArrayList.add(new Product(33,"software"));
        mProductArrayList.add(new Product(34,"software"));
        mProductArrayList.add(new Product(35,"software"));
        mProductArrayList.add(new Product(36,"software"));
        mProductArrayList.add(new Product(37,"software"));

        adapter1 = new MyAdapter(MainActivity.this, mProductArrayList);
        lvProducts.setAdapter(adapter1);


    }




    // Adapter Class
    public class MyAdapter extends BaseAdapter implements Filterable {

        private ArrayList<Product> mOriginalValues; // Original Values
        private ArrayList<Product> mDisplayedValues;    // Values to be displayed
        LayoutInflater inflater;

        public MyAdapter(Context context, ArrayList<Product> mProductArrayList)
        {
            this.mOriginalValues = mProductArrayList;
            this.mDisplayedValues = mProductArrayList;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mDisplayedValues.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        private class ViewHolder {
            RelativeLayout llContainer;
            TextView tvName,tvnumber;
            CheckBox  checkBox;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;

            if (convertView == null)
            {

                holder = new ViewHolder();
                convertView = inflater.inflate(R.layout.row, null);
                holder.llContainer = (RelativeLayout) convertView.findViewById(R.id.llContainer);
                holder.tvName = (TextView) convertView.findViewById(R.id.tvname);
                holder.tvnumber = (TextView) convertView.findViewById(R.id.tvnumber);
                holder.checkBox=  convertView.findViewById(R.id.checkbox);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tvName.setText(mDisplayedValues.get(position).getName());
            holder.tvnumber.setText(String.valueOf(mDisplayedValues.get(position).getId()));
          //  holder.tvPrice.setText(mDisplayedValues.get(position).price+"");

            holder.checkBox.setChecked(mDisplayedValues.get(position).isChecked());

            holder.checkBox.setTag(mDisplayedValues.get(position).getId());



            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(((CompoundButton) view).isChecked()){
                        System.out.println("Checked");


                        mOriginalValues.get((Integer) view.getTag()).setChecked(true);
                        mDisplayedValues.get((Integer) view.getTag()).setChecked(true);

                        Toast.makeText(MainActivity.this, ""+true, Toast.LENGTH_SHORT).show();


                    } else {

                        mOriginalValues.get((Integer) view.getTag()).setChecked(false);
                        mDisplayedValues.get((Integer) view.getTag()).setChecked(false);
                    }
                }
            });

            return convertView;
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter()
            {

                @SuppressWarnings("unchecked")
                @Override
                protected void publishResults(CharSequence constraint,FilterResults results) {

                    mDisplayedValues = (ArrayList<Product>) results.values; // has the filtered values
                    notifyDataSetChanged();  // notifies the data with new filtered values
                }

                @Override
                protected FilterResults performFiltering(CharSequence constraint)
                {
                    FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
                    ArrayList<Product> FilteredArrList = new ArrayList<Product>();

                    if (mOriginalValues == null) {
                        mOriginalValues = new ArrayList<Product>(mDisplayedValues); // saves the original data in mOriginalValues
                    }

                    /********
                     *
                     *  If constraint(CharSequence that is received) is null returns the mOriginalValues(Original) values
                     *  else does the Filtering and returns FilteredArrList(Filtered)
                     *
                     ********/
                    if (constraint == null || constraint.length() == 0)
                    {

                        // set the Original result to return
                        results.count = mOriginalValues.size();
                        results.values = mOriginalValues;
                    } else
                        {
                        constraint = constraint.toString().toLowerCase();
                        for (int i = 0; i < mOriginalValues.size(); i++) {
                            String data = mOriginalValues.get(i).name;
                            if (data.toLowerCase().startsWith(constraint.toString()))
                            {
                                FilteredArrList.add(new Product(mOriginalValues.get(i).name,mOriginalValues.get(i).isChecked()));

                            }
                        }
                        // set the Filtered result to return
                        results.count = FilteredArrList.size();
                        results.values = FilteredArrList;
                    }
                    return results;
                }
            };
            return filter;
        }
    }




}
