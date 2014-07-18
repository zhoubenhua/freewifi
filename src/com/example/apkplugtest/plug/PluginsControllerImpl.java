package com.example.apkplugtest.plug;

import java.util.List;

import org.osgi.framework.Bundle;

import android.view.View;

import com.chinaway.framework.swordfish.plugin.PluginsController;

public class PluginsControllerImpl implements PluginsController {
	private List<View> pages = null;

	public PluginsControllerImpl(List<View> pages) {
		this.pages = pages;
	}

	@Override
	public void addView(Bundle bundle, View view, int index) {
		pages.add(view);

	}

	@Override
	public void removeView(Bundle bundle, View view) {
		pages.remove(view);

	}

}
