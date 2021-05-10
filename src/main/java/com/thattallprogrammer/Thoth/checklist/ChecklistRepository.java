package com.thattallprogrammer.Thoth.checklist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChecklistRepository extends JpaRepository<Checklist, String>
{

}
