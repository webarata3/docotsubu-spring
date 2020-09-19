package first.docotsubu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import first.docotsubu.entity.Mutter;
import first.docotsubu.repository.MutterRepository;

@Service
public class MutterService {
    @Autowired
    private MutterRepository mutterRepository;

    public List<Mutter> getAllMutter() {
        return mutterRepository.selectAll();
    }

    public void add(Mutter mutter) {
        mutterRepository.insert(mutter);
    }
}
