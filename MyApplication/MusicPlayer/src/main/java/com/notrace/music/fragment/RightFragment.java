/**
 * Copyright (c) www.longdw.com
 */
package com.notrace.music.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.notrace.music.R;

/**
 * 
 * @author longdw(longdawei1988@gmail.com)
 *
 */
public class RightFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.viewpager_trans_layout, container, false);
	}

}
