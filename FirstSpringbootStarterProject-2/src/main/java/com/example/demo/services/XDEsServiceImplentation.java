package com.example.demo.services;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.JobsRepository;
import com.example.demo.data.XDEsRepository;
import com.example.demo.models.Job;
import com.example.demo.models.XDE;

@Service
public class XDEsServiceImplentation implements XDEsService {

	@Autowired
	XDEsRepository repositroy;

	@Autowired
	JobsRepository jobsRepo;

	@Override
	public boolean saveDataToDataBase(List<XDE> xdesList) {
		xdesList.forEach(x -> repositroy.save(x));
		return true;
	}

	@Override
	public boolean saveXDEsToJob(List<XDE> xdesList, UUID id) {
		Job job = jobsRepo.getFromId(id);
		if (job == null)
			throw new EntityNotFoundException("No job found");
		else {
			try {
				job.getXdeList().addAll(xdesList);
				xdesList.forEach(x -> {
					x.setJob(job);
					repositroy.save(x);
				});
				jobsRepo.save(job);
				return true;

			} catch (Exception e) {
				return false;

			}

		}

	}

}
