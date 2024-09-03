package in.fl.los.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.fl.los.model.ReceiptsYblUpiLog;

@Repository
public interface ReceiptsYblUpiLogRepository extends JpaRepository<ReceiptsYblUpiLog, Integer> {

	ReceiptsYblUpiLog findByExecTrxnNo(String execTrxnNo);

	ReceiptsYblUpiLog findFirstByExecTrxnNo(String execTrxnNo);

	ReceiptsYblUpiLog findByid(int Id);
}
