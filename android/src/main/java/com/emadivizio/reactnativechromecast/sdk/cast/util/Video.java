package com.emadivizio.reactnativechromecast.sdk.cast.util;

/**
 * Created by Emanuele on 12/09/2017.
 */
public class Video {
  private String url, title, subtitle, imageUri;
  private int duration;
  private StreamType type;
  private String mimeType;
  private int progress;

  public Video(String url, String title, String subtitle, String imageUri, int duration, StreamType type, String mimeType, int progress) {
    this.url = url;
    this.title = title;
    this.subtitle = subtitle;
    this.imageUri = imageUri;
    this.duration = duration;
    this.type = type;
    this.mimeType = mimeType;
    this.progress = progress;
  }


  public String getUrl() {
    return url;
  }

  public String getTitle() {
    return title;
  }

  public String getSubtitle() {
    return subtitle;
  }

  public String getImageUri() {
    return imageUri;
  }

  public int getDuration() {
    return duration;
  }

  public StreamType getType() {
    return type;
  }

  public String getMimeType() {
    return mimeType;
  }

  public int getProgress() {
    return progress;
  }

  public enum StreamType {
    LIVE, BUFFER
  }
}
