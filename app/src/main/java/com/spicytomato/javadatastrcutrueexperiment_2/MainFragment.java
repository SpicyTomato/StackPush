package com.spicytomato.javadatastrcutrueexperiment_2;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateVMFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.spicytomato.javadatastrcutrueexperiment_2.databinding.FragmentMainBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_main, container, false);

        final MyViewModel myViewModel;
        myViewModel =ViewModelProviders.of(requireActivity(),new SavedStateVMFactory(requireActivity())).get(MyViewModel.class);

        final FragmentMainBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());

        binding.buttonInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myViewModel.getStackHead().getValue() == null) {
                    myViewModel.getStackHead().setValue(new Stack<String>());
                    binding.textViewHint.setText("初始化成功");
                }else{
                    binding.textViewHint.setText("已经存在一个栈了");
                }
            }
        });

        binding.buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myViewModel.getStackHead().getValue() !=null && !myViewModel.getStackHead().getValue().isEmpty()){
                    myViewModel.getStackHead().getValue().StackClear();
                    binding.textViewHint.setText("清空成功");
                }else if (myViewModel.getStackHead().getValue() == null){
                    binding.textViewHint.setText("请初始化一个栈");
                }
            }
        });

        binding.buttonPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myViewModel.getStackHead().getValue() != null) {
                    NavController controller = Navigation.findNavController(v);
                    controller.navigate(R.id.action_mainFragment_to_pushFragment);
                }else{
                    binding.textViewHint.setText("请初始化一个栈");
                }

            }
        });

        binding.buttonPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myViewModel.getStackHead().getValue() != null && !myViewModel.getStackHead().getValue().isEmpty()) {
                    binding.textViewHint.setText("出栈成功 出栈值为: " + myViewModel.getStackHead().getValue().StackPop());
                }else if (myViewModel.getStackHead().getValue() == null){
                    binding.textViewHint.setText("请初始化一个栈");
                }else{
                    binding.textViewHint.setText("栈为空");
                }
            }
        });

        binding.buttonPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myViewModel.getStackHead().getValue() != null && !myViewModel.getStackHead().getValue().isEmpty()){
                    binding.textViewPrint.setText(myViewModel.getStackHead().getValue().toString());
                }else if(myViewModel.getStackHead().getValue() == null){
                    binding.textViewPrint.setText("请初始化一个栈");
                }else {
                    binding.textViewHint.setText("栈为空");
                }
            }
        });

        return binding.getRoot();
    }

}
