/**
 * Copyright (c) www.longdw.com
 */
package com.notrace.music.interfaces;

import com.notrace.music.model.MusicInfo;

import java.util.List;



public interface IQueryFinished {
	
	public void onFinished(List<MusicInfo> list);

}
