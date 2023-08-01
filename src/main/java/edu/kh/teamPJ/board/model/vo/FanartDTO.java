package edu.kh.teamPJ.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class FanartDTO {
   
   private int photoNo;
   private String title;
   private String photo;
   
   public FanartDTO() {}

   public FanartDTO(int photoNo, String title, String photo) {
      this.photoNo = photoNo;
      this.title = title;
      this.photo = photo;
   }


   public int getPhotoNo() {
      return photoNo;
   }

   public void setPhotoNo(int photoNo) {
      this.photoNo = photoNo;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getPhoto() {
      return photo;
   }

   public void setPhoto(String photo) {
      this.photo = photo;
   }


   @Override
   public String toString() {
      return "FanartDTO [photoNo=" + photoNo + ", title=" + title + ", photo=" + photo + "]";
   }

   
   
}
