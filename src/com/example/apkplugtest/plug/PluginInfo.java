package com.example.apkplugtest.plug;

public class PluginInfo {

	private int id;
	private String pluginTag;
	private String pluginName;
	private String packageName;
	private String downloadPath;
	private String versionCode;
	private String versionName;
	private String desc;
	private int available;

	/**
	 * Default constructor for plugin
	 * 
	 */
	public PluginInfo() {

	}

	/**
	 * Constructor for plugin
	 * 
	 * @param pluginTag
	 * @param pluginName
	 * @param packageName
	 * @param downloadPath
	 * @param versionCode
	 * @param versionName
	 * @param desc
	 * @param available
	 */
	public PluginInfo(String pluginTag, String pluginName, String packageName,
			String downloadPath, String versionCode, String versionName,
			String desc, int available) {
		super();
		this.pluginTag = pluginTag;
		this.pluginName = pluginName;
		this.packageName = packageName;
		this.downloadPath = downloadPath;
		this.versionCode = versionCode;
		this.versionName = versionName;
		this.desc = desc;
		this.available = available;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPluginTag() {
		return pluginTag;
	}

	public void setPluginTag(String pluginTag) {
		this.pluginTag = pluginTag;
	}

	public String getPluginName() {
		return pluginName;
	}

	public void setPluginName(String pluginName) {
		this.pluginName = pluginName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getDownloadPath() {
		return downloadPath;
	}

	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}

	public String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

}
