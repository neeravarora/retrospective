package com.neerav.dao;

import java.util.List;

import com.neerav.model.WhatWentWell;



public interface WhatWentWellDao {

	public void addWhatWentWell(WhatWentWell p);
	public void updateWhatWentWell(WhatWentWell p);
	public List<WhatWentWell> listWhatWentWell();
	public WhatWentWell getWhatWentWellById(int id);
	public void removeWhatWentWell(int id);
}