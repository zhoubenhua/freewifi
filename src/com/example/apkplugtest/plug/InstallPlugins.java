package com.example.apkplugtest.plug;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apkplug.Bundle.BundleControl;
import org.apkplug.Bundle.installCallback;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import android.content.Context;
/**
 * ���PropertyInstance.AutoStart()�Ĺ���
 * @author ��ǰ��
 */
public class InstallPlugins {
	public void installBundle(Context context,BundleContext mBundleContext,installCallback callback){
				//��BundleDemo1.apk��assets�ļ���������Ӧ�ð�װĿ¼��
				File f0=null,f1=null;
				 try {
					 	//��assetsĿ¼�и���apk�ļ���SD����
						InputStream in=context.getAssets().open("DBTasks.apk");
						f0=new File(context.getFilesDir(),"DBTasks.apk");
						if(!f0.exists()){
							copy(in, f0);
							//��һ������ʱִ�а�װ,�Ժ�Ͳ�ִ����
							// startlevel����Ϊ1��������� isCheckVersion��������汾���Ǹ���
							this.install(mBundleContext,"file:"+f0.getAbsolutePath(),callback,1,false);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				 try {
					 	//��assetsĿ¼�и���apk�ļ���SD����
						InputStream in=context.getAssets().open("OrderTask.apk");
						f1=new File(context.getFilesDir(),"OrderTask.apk");
						if(!f1.exists()){
							copy(in, f1);
							//��һ������ʱִ�а�װ,�Ժ�Ͳ�ִ����
							// startlevel����Ϊ1��������� isCheckVersion��������汾���Ǹ���
							this.install(mBundleContext,"file:"+f1.getAbsolutePath(),callback,1,false);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				 try {
					 	//��assetsĿ¼�и���apk�ļ���SD����
						InputStream in=context.getAssets().open("Storage.apk");
						f1=new File(context.getFilesDir(),"Storage.apk");
						if(!f1.exists()){
							copy(in, f1);
							//��һ������ʱִ�а�װ,�Ժ�Ͳ�ִ����
							// startlevel����Ϊ1��������� isCheckVersion��������汾���Ǹ���
							this.install(mBundleContext,"file:"+f1.getAbsolutePath(),callback,1,false);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
			      
	}
	private void copy(InputStream is, File outputFile)
	        throws IOException
	    {
	        OutputStream os = null;

	        try
	        {
	            os = new BufferedOutputStream(
	                new FileOutputStream(outputFile),4096);
	            byte[] b = new byte[4096];
	            int len = 0;
	            while ((len = is.read(b)) != -1)
	                os.write(b, 0, len);
	        }
	        finally
	        {
	            if (is != null) is.close();
	            if (os != null) os.close();
	        }
	    }
	/**
	  * ��װ���ز���������
	  * ��ϸ�ӿڲμ� http://www.apkplug.com/javadoc/bundledoc1.5.3/
	  * org.apkplug.Bundle 
     *      �ӿ� BundleControl
	  * @param path
	  * @param callback   ��װ����Ļص�����
	  * @throws Exception
	  */
	 private void install(BundleContext mcontext,String path,installCallback callback,int startlevel,boolean isCheckVersion) throws Exception{
		 System.out.println("��װ :"+path);
			ServiceReference reference=mcontext.getServiceReference(BundleControl.class.getName());
	    	if(null!=reference){
	    		BundleControl service=(BundleControl) mcontext.getService(reference);
	    		if(service!=null){
	    			//�����������Ϊ1(������) ���Ҳ�������汾�Ƿ���ͬ����װ
	    			service.install(mcontext, path,callback, startlevel,isCheckVersion);
	    		}
	    		mcontext.ungetService(reference);
	    	}
	}
}
