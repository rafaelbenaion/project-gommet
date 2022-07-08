package com.uca.core;
import com.uca.dao.StudentStickersDAO;
import com.uca.entity.StudentStickersEntity;
import com.uca.entity.StickerEntity;
import spark.Request;

import java.util.ArrayList;

public class StudentStickersCore 
{
    
    /* -------------------------------------------------------------------------- */
    /* Get all student stickers :                                                 */
    /* -------------------------------------------------------------------------- */

    public static ArrayList<StudentStickersEntity> getAllStudentStickers() 
    {
        return new StudentStickersDAO().getAllStudentStickers();
    }

    /* -------------------------------------------------------------------------- */
    /* Get one sticker with id :                                                  */
    /* -------------------------------------------------------------------------- */
    
    public static StickerEntity getSticker(int id) 
    {
        return new StudentStickersDAO().getSticker(id);
    }

    /* -------------------------------------------------------------------------- */
    /* Get all stickers :                                                         */
    /* -------------------------------------------------------------------------- */

    public static ArrayList<StickerEntity> getAllStickers() 
    {
        return new StudentStickersDAO().getAllStickers();
    }

    /* -------------------------------------------------------------------------- */
    /* Create new sticker :                                                       */
    /* -------------------------------------------------------------------------- */

    public static void createSticker(StickerEntity sticker) 
    {
        new StudentStickersDAO().createSticker(sticker);
    }

    /* -------------------------------------------------------------------------- */
    /* Delete sticker with id :                                                   */
    /* -------------------------------------------------------------------------- */

    public static void deleteSticker(int id) 
    {
        new StudentStickersDAO().deleteSticker(id);
    }

    /* -------------------------------------------------------------------------- */
    /* Update sticker with id :                                                   */
    /* -------------------------------------------------------------------------- */

    public static void updateSticker(int id, Request req) 
    {
        new StudentStickersDAO().updateSticker(id, req);
    }

    /* -------------------------------------------------------------------------- */
    /* Delete sticker with id :                                                   */
    /* -------------------------------------------------------------------------- */

    public static void deleteStudentSticker(int id) 
    {
        new StudentStickersDAO().deleteStudentSticker(id);
    }

    /* -------------------------------------------------------------------------- */
    /* Assign sticker to a student :                                              */
    /* -------------------------------------------------------------------------- */

    public static void giveStudentSticker(Request req) 
    {
        new StudentStickersDAO().giveStudentSticker(req);
    }

}
