package com.example.apkplugtest;

import java.util.ArrayList;
import java.util.List;

import org.apkplug.Bundle.installCallback;
import org.apkplug.app.FrameworkFactory;
import org.apkplug.app.FrameworkInstance;
import org.osgi.framework.BundleActivator;

import com.chinaway.framework.swordfish.plugin.PluginsController;
import com.example.apkplugtest.plug.InstallPlugins;
import com.example.apkplugtest.plug.PluginsActivator;
import com.example.apkplugtest.plug.PluginsControllerImpl;

import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends Activity {
	private List<View> mPages;
	private MyPagerAdapter mAdapter;
	private ViewPager viewPager;
	private FrameworkInstance mFrame;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        
    	mPages = new ArrayList<View>();
		// search & load the plugins
    	//mPages = mApp.loadPlugins();
    	PluginsController plugView = new PluginsControllerImpl(mPages);
		PluginsActivator activator = new PluginsActivator(plugView);
		List<BundleActivator> activators = new java.util.ArrayList<BundleActivator>();
		activators.add(activator);
		try {
			mFrame = FrameworkFactory.getInstance().start(activators, this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//安装插件
		InstallPlugins ib = new InstallPlugins();
		ib.installBundle(getApplicationContext(), mFrame.getSystemBundleContext(),
				new installCallback() {
					@Override
					public void callback(int arg0, org.osgi.framework.Bundle arg1) {
						if (arg0 == installCallback.stutas5
								|| arg0 == installCallback.stutas7) {
							Log.d("",
									String.format("插件安装 %s ： %d",
											arg1.getName(), arg0));
							return;
						} else {
							Log.d("", "插件安装失败 ：%s" + arg1.getName());
						}
					}
				});
		mAdapter = new MyPagerAdapter();
		viewPager.setAdapter(mAdapter);
		


    }
    
    class MyPagerAdapter extends PagerAdapter {
		public MyPagerAdapter() {
		}

		@Override
		public void destroyItem(View view, int position, Object arg2) {
			((ViewPager) view).removeView(mPages.get(position));
		}

		@Override
		public void finishUpdate(View arg0) {
		}

		@Override
		public int getCount() {
			return mPages.size();
		}

		@Override
		public Object instantiateItem(View view, int position) {
			((ViewPager) view).addView(mPages.get(position), 0);
			return mPages.get(position);
		}

		@Override
		public boolean isViewFromObject(View view, Object obj) {
			return view == (obj);
		}

		@Override
		public void restoreState(Parcelable pl, ClassLoader cl) {
		}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
		}
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
