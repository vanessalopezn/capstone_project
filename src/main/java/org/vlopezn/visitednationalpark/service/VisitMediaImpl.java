package org.vlopezn.visitednationalpark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vlopezn.visitednationalpark.model.VisitMedia;
import org.vlopezn.visitednationalpark.repository.VisitMediaRepository;

import java.util.List;

@Service
public class VisitMediaImpl implements IVisitMedia{

    @Autowired
    VisitMediaRepository mediaRepository;

    @Override
    public List<VisitMedia> getMediaByVisitId(Long visit_id) {
        return mediaRepository.getVisitMediaByVisitId(visit_id);
    }
}
