package com.example.apkplugtest.plug;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.chinaway.framework.swordfish.plugin.PluginsController;



public class PluginsActivator implements BundleActivator {
	
	private ServiceRegistration m_reg = null;
	private PluginsController mPc = null;

	public PluginsActivator(PluginsController pc) {
		this.mPc = pc;
	}

	@Override
	public void start(final BundleContext context) {
		// 注册�?��服务给插件调�?
		m_reg = context.registerService(PluginsController.class.getName(), mPc,
				null);

	}

	@Override
	public void stop(BundleContext arg0) {
		m_reg.unregister();
	}
}
