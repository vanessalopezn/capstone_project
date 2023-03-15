/**
 * @Author Vanessa Lopez Nunez
 * @Class IVisitMedia
 * Visit media service to handle the information.
 */
package org.vlopezn.visitednationalpark.service;

import org.vlopezn.visitednationalpark.model.VisitMedia;
import java.util.List;

public interface IVisitMedia {

    List<VisitMedia> getMediaByVisitId(Long visit_id);
}
